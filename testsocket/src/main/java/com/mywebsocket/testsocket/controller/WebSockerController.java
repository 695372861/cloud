package com.mywebsocket.testsocket.controller;

import com.mywebsocket.testsocket.entity.ChatRoomRequest;
import com.mywebsocket.testsocket.entity.ChatRoomResponse;
import com.mywebsocket.testsocket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
@EnableScheduling//使用这个注解和@Scheduled这个注解配合进行定时执行一个方法
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

    @RequestMapping("/upfile")
    @ResponseBody
    public String  upfile(HttpServletRequest req)
    {
        String userName=req.getParameter("userName");
        System.out.println(userName);
        String pathNameFile="";
        List<MultipartFile> files = ((MultipartHttpServletRequest) req)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        String str=System.getProperty("user.dir");
        str=str.replace("\\","/");
        System.out.println(str);
        str=str.substring(0,str.lastIndexOf("/"))+"/uploadfile/";
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    String uploadFilePath = file.getOriginalFilename();
                    System.out.println("uploadFlePath:" + uploadFilePath);
                    // 截取上传文件的文件名
                    String uploadFileName = uploadFilePath
                            .substring(uploadFilePath.lastIndexOf('\\') + 1,
                                    uploadFilePath.indexOf('.'));
                    System.out.println("multiReq.getFile()" + uploadFileName);
                    // 截取上传文件的后缀
                    String uploadFileSuffix = uploadFilePath.substring(
                            uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
                    System.out.println("uploadFileSuffix:" + uploadFileSuffix);
                    //文件的路径名
                    pathNameFile=str+"123" + uploadFileName + "." + uploadFileSuffix;
                    stream = new BufferedOutputStream(new FileOutputStream(new File(pathNameFile)));
                    byte[] bytes = file.getBytes();
                    stream.write(bytes,0,bytes.length);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("上传文件为空");
            }
        }
        System.out.println("文件接受成功了:"+pathNameFile+":"+files.size());
        return "成功辣";
    }


}
