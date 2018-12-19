package com.demo181108.userdemo.service.impl;

import com.demo181108.userdemo.dao.UserDao;
import com.demo181108.userdemo.domain.User;
import com.demo181108.userdemo.entity.PageBean;
import com.demo181108.userdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public int selectCount() {
        return userDao.selectCount();
    }

    @Override
    public int addUser(User record) {
        return userDao.addUser(record);
    }

    @Override
    public User getByLoginId(String loginId) {
        User user = userDao.getByLoginId(loginId);
        if (user == null){
            return null;
        }
        else {
            return user;
        }
    }

    @Override
    public int updateUserById(User record) {
        return userDao.updateUserById(record);
    }

    @Override
    public int deleteById(String id) {
        return userDao.deleteById(id);
    }


    @Override
    public PageBean<User> findByPage(int currentPage) {
        final int pageSize = 7;//每页显示数据个数
        final int totalCount = userDao.selectCount();

        HashMap<String , Object> map = new HashMap<String, Object>();
        PageBean<User> pageBean = new PageBean<User>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        pageBean.setPageSize(pageSize);

        //封装所有记录
        pageBean.setTotalCount(totalCount);

        //封装页数
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1) * pageSize);
        map.put("size",pageBean.getPageSize());

        //封装内容
        List<User> users = userDao.findByPage(map);
        pageBean.setLists(users);

        return  pageBean;
    }




}
