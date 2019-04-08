package com.ll.secondhouse.controller;


import com.ll.secondhouse.bean.users;
import com.ll.secondhouse.mapper.usersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("userservice")
public class usersController {

    @Autowired
    usersMapper usersMapper;

    @RequestMapping(value = "checkusername",method = RequestMethod.GET)
    public users checkusername(@RequestParam("username") String username){
        return usersMapper.checkusernmae(username);
    }

    @RequestMapping(value = "logincheck",method = RequestMethod.GET)
    public users logincheck(@RequestParam("username") String username , @RequestParam("password") String password){
        System.out.println("username : "+ username);
        return usersMapper.logincheck(username,password);
    }

    @RequestMapping(value = "updateusers",method = RequestMethod.GET)
    public int updateusers(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("userid")int id){
        users users = usersMapper.getusersbyId(id);
        users.setU_username(username);
        users.setU_password(password);
        return usersMapper.updateusers(users);
    }
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public void deleteusers(@RequestParam("id")int id){
        usersMapper.deleteUsersById(id);
        return;
    }

    @RequestMapping(value = "registry",method = RequestMethod.POST)
    public int registryUsers(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("email")String email){
        System.out.println("注册新用户");
        users users = new users(0,username,password,email,new SimpleDateFormat().format(new Date()));
        return usersMapper.registry(users);
    }

    @RequestMapping(value = "controller",method = RequestMethod.GET)
    public users controllerdenglu(@RequestParam("username")String username,@RequestParam("password")String password){

        if (username.equals(username) && password.equals(password)){
            System.out.println(username);
            System.out.println(password);
            users users = usersMapper.logincheck(username,password);
            System.out.println(users);
            return users;
        }else{
            return null;
        }
    }

}
