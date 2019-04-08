package com.ll.secondhouse.controller;
import com.ll.secondhouse.mapper.messageRecieved;
import com.ll.secondhouse.mapper.messageSend;
import com.ll.secondhouse.mapper.usersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ll.secondhouse.bean.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("messageService")
public class MessageController {
    @Autowired
    messageSend messageSend;
    @Autowired
    messageRecieved messageRecieved;
    @Autowired
    usersMapper usersMapper;

    //查看已经发送的message
    @RequestMapping(value = "seesendmessage/{id}",method = RequestMethod.GET)
    public List<messagesend> seesendmessage(@PathVariable("id")int id){
        System.out.println("asdf");
        List<messagesend> list = messageSend.getsendermessgeByid(id);
        System.out.println(list);
        return list;
    }

    //查看已经接收到的message
    @RequestMapping(value = "seerecievedmessage/{id}",method = RequestMethod.GET)
    public List<messagerecieved> seerecievedmessage(@PathVariable("id")int id){
        System.out.println("asdf");
        List<messagerecieved> list = messageRecieved.getsendermessgeByid(id);
        System.out.println(list);
        return list;
    }

    @RequestMapping("sendmessage")
    public void sendmessage(@RequestParam("senderid")int senderid,@RequestParam("recievedid")int recieverid,@RequestParam("content")String content){
        messageSend.sendmessage(new messagesend(0,senderid,recieverid,content,new SimpleDateFormat().format(new Date())));
        messageRecieved.recievedmessage(new messagerecieved(0,senderid,recieverid,content,new SimpleDateFormat().format(new Date())));
        return;
    }

    @RequestMapping("deletesendmessagebyid/{id}")
    public void deletesendmessagebiID(@PathVariable("id")int id){
        messageSend.deletesendid(id);
    }
    @RequestMapping("deletrecievedmessagebyid/{id}")
    public void deleterecievedmessagebiID(@PathVariable("id")int id){
        messageRecieved.deletereciedByid(id);
    }

    @RequestMapping("cleanupSendMessage/{id}")
    public void cleanupsendmessage(@PathVariable("id") int id){
        messageSend.cleanUpMessage(id);
    }

    @RequestMapping("cleanupRecievedMessage/{id}")
    public void cleanuprecievedmessage(@PathVariable("id") int id){
        messageRecieved.cleanUpMessage(id);
    }

    @RequestMapping(value = "sendtoallpeople",method = RequestMethod.GET)
    public void sendallpeople(@RequestParam("senderid")int id,@RequestParam("contentsend")String contentsend,@RequestParam("content")String content){
        List<users> list = usersMapper.findallusers();
        for(int i =0;i<list.size();i++){
            int a = list.get(i).getU_id();
            if( a != id){
                messageRecieved.recievedmessage(new messagerecieved(0,id,a,content,new SimpleDateFormat().format(new Date())));
            }else{
                messageSend.sendmessage(new messagesend(0,id,id,contentsend,new SimpleDateFormat().format(new Date())));
            }
        }
    }
}
