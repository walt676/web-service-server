package com.demo181108.userdemo.controller;

import com.demo181108.userdemo.service.VoiceSynthesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class VoiceSynthesisController {

    @Autowired
    VoiceSynthesisService voiceSynthesisService;

    @CrossOrigin
    @RequestMapping(value = "/getVoiceSynthesis",method = RequestMethod.GET)
    public ResponseEntity<?> getVoiceSynthesis(@RequestParam(value = "originalText") String originalText){
        try {
            Map<String, Object> map = voiceSynthesisService.getVoice(originalText);

            if (map.get("isSuccess").equals("no") && map.get("body").toString().contains("illegal client_ip")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("语音合成失败，请老师联系我添加科大讯飞api的ip白名单");
            }
             byte[] body = (byte[]) map.get("body");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition","attachment;filename="+map.get("sid")+".wav");
            HttpStatus status = HttpStatus.OK;
            return new ResponseEntity<byte[]>(body,headers,status);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("语音合成失败，错误未知");
    }

}
