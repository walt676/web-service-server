package com.demo181108.userdemo.dao;

import com.demo181108.userdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserDao {

    List<User> getAll();

    int selectCount();

    List<User> findByPage(HashMap<String ,Object > map);

    int addUser(User record);

    User getByLoginId(String id);

    int updateUserById(User record);

    int deleteById(String id);

}

