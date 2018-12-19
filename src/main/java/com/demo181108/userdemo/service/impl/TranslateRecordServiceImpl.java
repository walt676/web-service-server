package com.demo181108.userdemo.service.impl;

import com.demo181108.userdemo.dao.TranslateRecordDao;
import com.demo181108.userdemo.domain.TranslateRecord;
import com.demo181108.userdemo.entity.PageBean;
import com.demo181108.userdemo.service.TranslateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TranslateRecordServiceImpl implements TranslateRecordService {

    @Autowired
    TranslateRecordDao translateRecordDao;

    @Override
    public int selectCount() {
        return translateRecordDao.selectCount();
    }

    @Override
    public int addTranslateRecord(TranslateRecord record) {
        return translateRecordDao.addTranslateRecord(record);
    }

    @Override
    public PageBean<TranslateRecord> findByPage(int currentPage,String user_id) {
        final int pageSize = 7;//每页显示数据个数
        final int totalCount = translateRecordDao.selectCountByUserId(user_id);

        HashMap<String , Object> map = new HashMap<String, Object>();
        PageBean<TranslateRecord> pageBean = new PageBean<TranslateRecord>();

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
        map.put("user_id",user_id);

        //封装内容
        List<TranslateRecord> translateRecords = translateRecordDao.findByPage(map);

        pageBean.setLists(translateRecords);

        return  pageBean;
    }

    @Override
    public int selectCountByUserId(String user_id) {
        return translateRecordDao.selectCountByUserId(user_id);
    }
}
