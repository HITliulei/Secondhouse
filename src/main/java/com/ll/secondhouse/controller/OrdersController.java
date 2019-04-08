package com.ll.secondhouse.controller;

import com.ll.secondhouse.bean.house;
import com.ll.secondhouse.bean.orders;
import com.ll.secondhouse.mapper.houseMapper;
import com.ll.secondhouse.mapper.ordersMapper;
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

    @RequestMapping("pushorder")
    public int pushorder(@RequestParam("userid")int userid,@RequestParam("houseid")int houseid){
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
        orders.setO_state(2);
        house house = houseMapper.findhouseById(orders.getH_id());
        house.setH_state(4);
        houseMapper.updatehouse(house);
        ordersMapper.update(orders);
    }


    @RequestMapping("deleteorders")
    public  void deleteorders(@RequestParam("id")int id){
        ordersMapper.deleteorders(id);
    }


}
