package com.ll.secondhouse.controller;

import com.ll.secondhouse.bean.appraise;
import com.ll.secondhouse.bean.recommend;
import com.ll.secondhouse.mapper.recommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ll.secondhouse.mapper.appraiseMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("appraiseservice")
public class Appraisecontroller {
    @Autowired
    appraiseMapper appraiseMapper;
    @Autowired
    recommendMapper recommendMapper;

    @RequestMapping(value = "addappraise",method = RequestMethod.GET)
    public int addAppraiseController(@RequestParam("content")String content, @RequestParam("a_userid")int userid,@RequestParam("a_house")int houseid){
        appraise appraise = new appraise(0,content,userid,houseid,new SimpleDateFormat().format(new Date()));
        System.out.println(appraise);
        return appraiseMapper.addAppraise(appraise);
    }

    @RequestMapping(value = "seehouseappraise",method = RequestMethod.GET)
    public List<appraise> seeAppraise(@RequestParam("hid")int id,@RequestParam("uid")int uid){
        if(uid == 0){
            return appraiseMapper.seehouseappraise(id);
        }else{
            /*添加权重*/
            recommend recommend = recommendMapper.checkScore(uid,id);
            if(recommend == null){
                recommendMapper.insertData(new recommend(0,uid,id,2));
            }else{
                int sc = recommend.getScore();
                if(sc<2){
                    recommendMapper.updateScore(new recommend(0,uid,id,2));
                }
            }
            return appraiseMapper.seehouseappraise(id);
        }
    }

    @RequestMapping(value = "getappraiseByuserid/{id}",method = RequestMethod.GET)
    public List<appraise> seeAppraisebyUserid(@PathVariable("id") int id){
        return appraiseMapper.userappraise(id);
    }

}
