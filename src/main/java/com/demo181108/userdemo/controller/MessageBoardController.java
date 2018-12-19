package com.demo181108.userdemo.controller;

import com.demo181108.userdemo.domain.MessageBoard;
import com.demo181108.userdemo.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageBoardController {

    @Autowired
    MessageBoardService messageBoardService;

    @CrossOrigin
    @RequestMapping(value = "getMessageBoard",method = RequestMethod.GET)
    public ResponseEntity<?> userTable(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage){
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("messageBoard",messageBoardService.findByPage(currentPage));
        System.out.println("返回留言板");
        return  ResponseEntity.ok(response);
    }


    @CrossOrigin
    @RequestMapping(value = "/insertMessageBoard",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> insertMessageBoard(@RequestBody Map map){

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());

        String title = (String) map.get("title");
        String author = (String) map.get("author");
        String content = (String) map.get("content");

        //实例化留言板数据
        MessageBoard newMessageBoard = new MessageBoard(title,author,content,time);

        messageBoardService.addMessageBoard(newMessageBoard);

        return ResponseEntity.ok(null);
    }

}
