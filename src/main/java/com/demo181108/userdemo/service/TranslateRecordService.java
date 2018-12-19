package com.demo181108.userdemo.service;

import com.demo181108.userdemo.domain.TranslateRecord;
import com.demo181108.userdemo.entity.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface TranslateRecordService {

    int selectCount();

    int addTranslateRecord(TranslateRecord record);

    PageBean<TranslateRecord> findByPage(int currentPage,String user_id);

    int selectCountByUserId(String user_id);
}
