package com.ll.secondhouse.controller;

import com.ll.secondhouse.bean.house;
import com.ll.secondhouse.bean.orders;
import com.ll.secondhouse.bean.recommend;
import com.ll.secondhouse.mapper.houseMapper;
import com.ll.secondhouse.mapper.ordersMapper;
import com.ll.secondhouse.mapper.recommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("orderservice")
public class OrdersController {

    @Autowired
    ordersMapper ordersMapper;
    @Autowired
    houseMapper houseMapper;
    @Autowired
    recommendMapper recommendMapper;

    @RequestMapping("pushorder")
    public int pushorder(@RequestParam("userid")int userid,@RequestParam("houseid")int houseid){
        recommend recommend = recommendMapper.checkScore(userid,houseid);
        if(recommend == null){
            recommendMapper.insertData(new recommend(0,userid,houseid,4));
        }else{
            int sc = recommend.getScore();
            if(sc<=4){
                recommendMapper.updateScore(new recommend(0,userid,houseid,4));
            }
        }
        house house = houseMapper.findhouseById(houseid);
        return ordersMapper.addorder(new orders(0,userid,houseid,new SimpleDateFormat().format(new Date()),1,house.getH_price()*0.01));
    }

    @RequestMapping("selectordersbyuserid/{id}")
    public List<orders> selectordersbyuserid(@PathVariable("id")int id){
        return ordersMapper.seemyorders(id);
    }
    @RequestMapping("findhouseorder")
    public orders findhouseorder(@RequestParam("id")int id){
        orders orders = ordersMapper.findordersbyhouse(id);
        System.out.println(orders);
        return orders;
    }

    @RequestMapping("selectordersbyid/{id}")
    public orders selectordersbyid(@PathVariable("id")int id){
        return ordersMapper.lookorders(id);
    }


    @RequestMapping("updateorders")
    public void updateorders(@RequestParam("id")int id){
        orders orders = ordersMapper.lookorders(id);
        int uid = orders.getU_id();
        int hid = orders.getH_id();
        orders.setO_state(2);
        house house = houseMapper.findhouseById(hid);
        house.setH_state(4);
        houseMapper.updatehouse(house);
        ordersMapper.update(orders);


        recommend recommend = recommendMapper.checkScore(uid,hid);
        if(recommend == null){
            recommendMapper.insertData(new recommend(0,uid,hid,5));
        }else{
            int sc = recommend.getScore();
            if(sc<5){
                recommendMapper.updateScore(new recommend(0,uid,hid,5));
            }
        }
    }
    @RequestMapping("deleteorders")
    public  void deleteorders(@RequestParam("id")int id){
        ordersMapper.deleteorders(id);
    }


}
