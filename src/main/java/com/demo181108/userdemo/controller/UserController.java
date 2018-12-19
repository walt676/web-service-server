package com.demo181108.userdemo.controller;

import com.demo181108.userdemo.domain.User;
import com.demo181108.userdemo.entity.PageBean;
import com.demo181108.userdemo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @CrossOrigin
//    @RequestMapping(value = "pic",method = RequestMethod.GET)
//    public List<User> pic(){
//        List<User> all = userService.getAll();
//        return all;
//    }

    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> getToken(@RequestBody Map map){
        //验证用户信息
        System.out.println(map);
        User user = userService.getByLoginId((String) map.get("loginName"));
        if (user == null){
            System.out.println("账号不存在");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("账号不存在！");
        }
        if (!map.get("password").equals(user.getPassword())){
            System.out.println("登录失败，用户名或密码错误！");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登录失败，用户名或密码错误！");
        }

        System.out.println(user);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("userId",user.getId().toString());
        response.put("username",user.getUsername());
        response.put("msg","登录成功");
        response.put("authority",user.getAuthority());
        return ResponseEntity.ok(response);
    }


    @CrossOrigin
    @RequestMapping(value = "userTable",method = RequestMethod.GET)
    public ResponseEntity<?> userTable(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage){
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("usertable",userService.findByPage(currentPage));
        System.out.println("返回用户表");
        return  ResponseEntity.ok(response);
    }

    @CrossOrigin
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> saveUser(@RequestBody Map map){
        Map<String,Object> response = new HashMap<String, Object>();
        User record = userService.getByLoginId((String) map.get("id"));
        record.setUsername((String) map.get("username"));
        record.setPassword((String) map.get("password"));
        record.setEmail((String) map.get("email"));
        record.setAuthority((Integer) map.get("authority"));
        userService.updateUserById(record);
        System.out.println(map);
        response.put("msg","成功修改信息");
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST )
    @ResponseBody
    public ResponseEntity<?> deleteUser(@RequestBody Map map){
        String id = (String) map.get("id");
        System.out.println(id);
        if (id == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到该用户,删除失败");
        }

        userService.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @RequestMapping(value = "/addUser", method = RequestMethod.POST )
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody Map map){
        String id = (String) map.get("id");
        String name = (String) map.get("name");
        String password = (String) map.get("password");
        String email = (String) map.get("email");

        //实例化新用户
        User user = new User(id, name, password, email, 0);

        System.out.println(user);
        userService.addUser(user);

        return ResponseEntity.ok(null);
    }

}
