package com.demo181108.userdemo.service;

import com.demo181108.userdemo.domain.User;
import com.demo181108.userdemo.entity.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAll();

    PageBean<User> findByPage(int currentPage);

    int selectCount();

    int addUser(User record);

    User getByLoginId(String loginId);

    int updateUserById(User record);

    int deleteById(String id);

}
