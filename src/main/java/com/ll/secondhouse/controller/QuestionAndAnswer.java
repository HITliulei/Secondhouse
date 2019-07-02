package com.ll.secondhouse.controller;

import com.ll.secondhouse.bean.answer;
import com.ll.secondhouse.bean.users;
import com.ll.secondhouse.mapper.answerMapper;
import com.ll.secondhouse.mapper.questionMapper;
import com.ll.secondhouse.mapper.usersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("answerandquestionservice")
public class QuestionAndAnswer {

    @Autowired
    answerMapper answerMapper;
    @Autowired
    questionMapper questionMapper;

    @Autowired
    usersMapper usersMapper;

    @RequestMapping("test")
    public List<users> test(){
        return usersMapper.findallusers();
    }



}
