package com.demo181108.userdemo.service.impl;

import com.demo181108.userdemo.dao.MessageBoardDao;
import com.demo181108.userdemo.domain.MessageBoard;
import com.demo181108.userdemo.entity.PageBean;
import com.demo181108.userdemo.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {

    @Autowired
    private MessageBoardDao messageBoardDao;

    @Override
    public List<MessageBoard> getAll() {
        return messageBoardDao.getAll();
    }

    @Override
    public PageBean<MessageBoard> findByPage(int currentPage) {
        final int pageSize = 7;//每页显示数据个数
        final int totalCount = messageBoardDao.selectCount();

        HashMap<String , Object> map = new HashMap<String, Object>();
        PageBean<MessageBoard> pageBean = new PageBean<MessageBoard>();

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
        List<MessageBoard> messageBoards = messageBoardDao.findByPage(map);
        pageBean.setLists(messageBoards);

        return  pageBean;
    }

    @Override
    public int selectCount() {
        return messageBoardDao.selectCount();
    }

    @Override
    public int addMessageBoard(MessageBoard messageBoard) {
        return messageBoardDao.addMessageBoard(messageBoard);
    }
}
