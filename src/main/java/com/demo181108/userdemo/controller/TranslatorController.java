package com.demo181108.userdemo.controller;

import com.demo181108.userdemo.domain.TranslateRecord;
import com.demo181108.userdemo.service.TranslateRecordService;
import com.demo181108.userdemo.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/webservice")
public class TranslatorController {

    @Autowired
    TranslatorService translatorService;
    @Autowired
    TranslateRecordService translateRecordService;

    @CrossOrigin
    @RequestMapping(value = "/translator",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> translator(@RequestBody Map map){
        Map<String,Object> response = new HashMap<String, Object>();

        //获得原文
        String originalText = (String) map.get("original");

        //获得翻译后List
        List<String> result = translatorService.getResult(originalText).getString();

        if (result.toString().contains("很抱歉，发现一个错误，请稍后再试！请联系我们")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("很抱歉该句翻译错误，请联系我们:http;//www.webxml.com.cn");
        }

        //获得用户id
        String userid = (String) map.get("userid");

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());

        //实例化翻译记录
        TranslateRecord translateRecord = new TranslateRecord(userid,originalText,result.toString(),time);
        //加入数据库
        translateRecordService.addTranslateRecord(translateRecord);

        response.put("result",result);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @RequestMapping(value = "/getTranslateRecord",method = RequestMethod.GET)
    public ResponseEntity<?> translateRecord(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage,
                                             @RequestParam(value = "user_id") String user_id){
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("translateRecord",translateRecordService.findByPage(currentPage,user_id));
        return ResponseEntity.ok(response);
    }

}
