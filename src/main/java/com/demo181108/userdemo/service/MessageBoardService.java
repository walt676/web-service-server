package com.demo181108.userdemo.service;

import com.demo181108.userdemo.domain.MessageBoard;
import com.demo181108.userdemo.entity.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageBoardService {

    List<MessageBoard> getAll();

    PageBean<MessageBoard> findByPage(int currentPage);

    int selectCount();

    int addMessageBoard(MessageBoard messageBoard);
}
