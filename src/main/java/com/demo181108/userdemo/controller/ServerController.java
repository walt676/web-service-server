package com.demo181108.userdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServerController {

    @CrossOrigin
    @RequestMapping(value = "/checkServer",method = RequestMethod.GET)
    public ResponseEntity<?> checkServer(){
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("online","在线");
        return ResponseEntity.ok(response);
    }

}
