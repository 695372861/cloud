package com.mywebsocket.testsocket.controller;

import com.mywebsocket.testsocket.entity.ChatRoomRequest;
import com.mywebsocket.testsocket.entity.ChatRoomResponse;
import com.mywebsocket.testsocket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSockerController {

    @Autowired
    //SpringBoot提供操作WebSocket的对象
    SimpMessagingTemplate template;

    //广播消息
    //为了测试，定时10S执行这个方法，向客户端推送
//    @Scheduled(fixedRate = 10000)
    @Scheduled(cron = "0/5 * * * * ? ")
    public void sendTopicMessage()
    {
        System.out.println("后台广播推送！");
        User user=new User();
        user.setAge(10);
        user.setUserName("oyzc");
        //参数一：客户端监听指定通道时，设定的访问服务器的URL,参数二：发送的消息（可以是对象、字符串等等）
        this.template.convertAndSend("/topic/getResponse",user);
    }

    @RequestMapping("index")
    public String index()
    {
        return "websocket";
    }
    @RequestMapping("login")
    public String login()
    {
        return "login";
    }

    //群发
    @MessageMapping("/massRequest")
    //SendTo 发送至 Broker 下的指定订阅路径
    @SendTo("/mass/getResponse")
    public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest){
        //方法用于群发测试
        System.out.println("name = " + chatRoomRequest.getName());
        System.out.println("chatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response=new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setChatValue(chatRoomRequest.getChatValue());
        return response;
    }

    //单独聊天
    @MessageMapping("/aloneRequest")
    public ChatRoomResponse alone(ChatRoomRequest chatRoomRequest){
        //方法用于一对一测试
        System.out.println("userId = " + chatRoomRequest.getUserId());
        System.out.println("name = " + chatRoomRequest.getName());
        System.out.println("chatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response=new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setChatValue(chatRoomRequest.getChatValue());
        this.template.convertAndSendToUser(chatRoomRequest.getUserId()+"","/alone/getResponse",response);
        return response;
    }
}
