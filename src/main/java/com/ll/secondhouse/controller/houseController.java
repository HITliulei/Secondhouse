package com.ll.secondhouse.controller;

import com.ll.secondhouse.bean.house;
import com.ll.secondhouse.bean.others;
import com.ll.secondhouse.bean.recommend;
import com.ll.secondhouse.mapper.houseMapper;
import com.ll.secondhouse.mapper.recommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ll.secondhouse.utils.*;

@RestController
@RequestMapping("housecontroller")
public class houseController {
    @Autowired
    houseMapper houseMapper;

    @Autowired
    recommendMapper recommendMapper;

    @RequestMapping(value = "registryhouse",method = RequestMethod.POST)
    public int addhouse(@RequestParam("name")String name,@RequestParam("address")String address,@RequestParam("produce")String produce,@RequestParam("price")double price,@RequestParam("userid")int id){
        System.out.println("新注册的房子"+id);
        return houseMapper.addhouse(new house(0,name,address,produce,new SimpleDateFormat().format(new Date()),1,price,id,id));
    }

    @RequestMapping(value = "selectnoreview",method = RequestMethod.GET)
    public List<house> noreview(){
        System.out.println("未审核的房子");
        return houseMapper.noreview();
    }

    @RequestMapping("reviewhouse")
    public List<house> review(){
        List<house> list = houseMapper.reviewhouse();
        return houseMapper.reviewhouse();
    }

    //过审核
    @RequestMapping("guoshenhehouse/{id}")
    public void guoshenhehouse(@PathVariable("id")int id){
        house house = houseMapper.findhouseById(id);
        house.setH_state(2);
        houseMapper.updatehouse(house);
    }

    //预定
    @RequestMapping("order")
    public void order(@RequestParam("userid")int userid,@RequestParam("houseid")int houseid){
        house house = houseMapper.findhouseById(houseid);
        house.setH_state(3);
        house.setH_buyer_id(userid);
        houseMapper.updatehouse(house);
    }

    //退订单
    @RequestMapping("outorder")
    public void outorder(@RequestParam("houseid")int houseid){
        house house = houseMapper.findhouseById(houseid);
        house.setH_state(2);
        house.setH_buyer_id(house.getH_user_id());
        houseMapper.updatehouse(house);
    }

    //删除房子
    @RequestMapping("deletehouse/{id}")
    public void deletehouse(@PathVariable("id")int id){
        houseMapper.deletehouse(id);
    }



    //尾款付清
    @RequestMapping("buyhouse")
    public void buyhouse(@RequestParam("houseid")int houseid){
        house house = houseMapper.findhouseById(houseid);
        house.setH_state(4);
        houseMapper.updatehouse(house);
    }

    //用户所有的房子
    @RequestMapping("userhouse/{id}")
    public List<house> userhouse(@PathVariable("id")int id){
        return houseMapper.userhouse(id);
    }

    //用户购买的房子
    @RequestMapping("buyerhouse/{id}")
    public List<house> buyerhouse(@PathVariable("id")int id){
        return houseMapper.buyerhouse(id);
    }


    @RequestMapping("gethousebuhouseid/{id}")
    public house gethousebuhouseid(@PathVariable("id")int id){
        return houseMapper.findhouseById(id);
    }


    @RequestMapping("housefind")
    public List<house> getlikelyhouse(@RequestParam("text")String name){
        List<house> houses = houseMapper.getlikelyhouse(name);
        System.out.println(name);
        System.out.println(houses);
        return houses;
    }

    @RequestMapping("likelymoney")
    public List<house> getlikelehousebymoney(@RequestParam("money")double money,@RequestParam("hid")int hid,@RequestParam("uid")int uid){
        List<house> houses = houseMapper.reviewhouse();
        List<house> house = new ArrayList<>();
        for(int i =0;i<houses.size();i++){
            double a = houses.get(i).getH_price() - money;
            if(a <= 500000.00){
                house.add(houses.get(i));
            }
        }
        recommend recommend = recommendMapper.checkScore(uid,hid);
        if(recommend == null){
            recommendMapper.insertData(new recommend(0,uid,hid,3));
        }else{
            int sc = recommend.getScore();
            if(sc<=3){
                recommendMapper.updateScore(new recommend(0,uid,hid,3));
            }
        }
        return house;
    }


    @RequestMapping("findhousebydistance")
    public List<house> getlikehousebuaddress(@RequestParam("address")String address,@RequestParam("hid")int hid,@RequestParam("uid")int uid){
        double a1 = (double)GetLatAndLngByBaidu.getLngAndLat(address).get("lng");
        double a2 = (double)GetLatAndLngByBaidu.getLngAndLat(address).get("lat");
        List<house> list = houseMapper.reviewhouse();
        List<house> list1 = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            double a = (double)GetLatAndLngByBaidu.getLngAndLat(list.get(i).getH_address()).get("lng");
            double b = (double)GetLatAndLngByBaidu.getLngAndLat(list.get(i).getH_address()).get("lat");
            double distance = PointToDistance.getDistanceFromTwoPoints(a2,a1,b,a);
            if(distance < 1000.00){
                list1.add(list.get(1));
            }
        }
        recommend recommend = recommendMapper.checkScore(uid,hid);
        if(recommend == null){
            recommendMapper.insertData(new recommend(0,uid,hid,3));
        }else{
            int sc = recommend.getScore();
            if(sc<=3){
                recommendMapper.updateScore(new recommend(0,uid,hid,3));
            }
        }
        return list1;
    }

    @RequestMapping("findothers")
    public List<others> getothers(@RequestParam("adress")String name) throws Exception{
        List<others> lists = new ArrayList<>();
        String url = "https://hrb.58.com/ershoufang/?key="+name;
        List<String> list = JsoupHelper.fecthByMap(url,"//div[@class='list-info']");
        for(int i=0;i<list.size();i++){
            others others = new others(list.get(i),url);
            lists.add(others);
        }
        System.out.println(lists);
        return lists;
    }

    @RequestMapping("near")
    public List<others> near(@RequestParam("adress")String name,@RequestParam("uid")int uid,@RequestParam("hid")int hid) throws Exception{
        List<others> lists = new ArrayList<>();
        String url = "https://hrb.58.com/ershoufang/?key="+name;
        List<String> list = JsoupHelper.fecthByMap(url,"//div[@class='list-info']");
        for(int i=0;i<list.size();i++){
            others others = new others(list.get(i),url);
            lists.add(others);
        }
        recommend recommend = recommendMapper.checkScore(uid,hid);
        if(recommend == null){
            recommendMapper.insertData(new recommend(0,uid,hid,3));
        }else{
            int sc = recommend.getScore();
            if(sc<=3){
                recommendMapper.updateScore(new recommend(0,uid,hid,3));
            }
        }
        return lists;
    }
}
