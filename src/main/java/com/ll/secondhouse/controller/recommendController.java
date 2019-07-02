package com.ll.secondhouse.controller;


import com.ll.secondhouse.bean.house;
import com.ll.secondhouse.bean.recommend;
import com.ll.secondhouse.bean.users;
import com.ll.secondhouse.mapper.houseMapper;
import com.ll.secondhouse.mapper.recommendMapper;
import com.ll.secondhouse.mapper.usersMapper;
import com.ll.secondhouse.utils.GetLatAndLngByBaidu;
import com.ll.secondhouse.utils.PointToDistance;
import com.ll.secondhouse.utils.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("recommend")
public class recommendController {

    @Autowired
    usersMapper usersMapper;
    @Autowired
    houseMapper houseMapper;
    @Autowired
    recommendMapper recommendMapper;

    @RequestMapping(value = "recommendByuser/{id}",method = RequestMethod.GET)
    public List<house> recommendByuser(@PathVariable("id")int id){
        List<house> result = new ArrayList<>();
        List<users> users = usersMapper.findallusers();
        users.remove(0);
        List<house> houses = houseMapper.reviewhouse();
        List<recommend> recommends = recommendMapper.findallscore();
        List<Integer> houseid = new Recommend().gettherecommendhouse(users,recommends,id);
        for(int i = 0 ;i<houseid.size();i++){
            house house = houseMapper.findhouseById(houseid.get(i));
            if(house.getH_state() == 2){
                result.add(house);
            }
        }
        for(house h :houses){
            if(houseid.contains(h.getH_id())){
                continue;
            }else{
                result.add(h);
            }
        }
        return result;
    }


    @RequestMapping(value = "recommendByusersaddress/{id}",method = RequestMethod.GET)
    public List<house> recommendByusersaddress(@PathVariable("id")int id){
        users users = usersMapper.getusersbyId(id);
        List<house> house = houseMapper.reviewhouse();
        List<Integer> houseid = new ArrayList<>();
        for(house hou : house){
            houseid.add(hou.getH_id());
        }
        String address = users.getU_address();
        double a1 = (double) GetLatAndLngByBaidu.getLngAndLat(address).get("lng");
        double a2 = (double)GetLatAndLngByBaidu.getLngAndLat(address).get("lat");
        Map<Integer,Double> housemap = new HashMap<>();
        int longth = house.size();
        for(int i = 0;i<longth;i++){
            double a = (double) GetLatAndLngByBaidu.getLngAndLat(house.get(i).getH_address()).get("lng");
            double b = (double)GetLatAndLngByBaidu.getLngAndLat(house.get(i).getH_address()).get("lat");
            double distance = PointToDistance.getDistanceFromTwoPoints(a2,a1,b,a);
            housemap.put(house.get(i).getH_id(),distance);
        }
        List<house> list = new ArrayList<>();
        for(int i=0;i<longth;i++){
            double a  = 1000000000.0;
            int h = 0;
            for(Integer hid:houseid){
                if(housemap.get(hid) <= a){
                    a = housemap.get(hid);
                    h = hid;
                }
            }
            housemap.put(h,1000000000.0);
            list.add(houseMapper.findhouseById(h));
        }
        return list;
    }


    @RequestMapping(value = "addScore",method = RequestMethod.GET)
    public void addScore(@RequestParam("uid")int uid,@RequestParam("hid")int hid,@RequestParam("score")int score){
        System.out.println("调用了");
        recommend recommend = recommendMapper.checkScore(uid,hid);
        if(recommend == null){
            recommendMapper.insertData(new recommend(0,uid,hid,score));
        }else{
            int sc = recommend.getScore();
            if(sc<score){
                recommendMapper.updateScore(new recommend(0,uid,hid,score));
            }
        }
    }
}
