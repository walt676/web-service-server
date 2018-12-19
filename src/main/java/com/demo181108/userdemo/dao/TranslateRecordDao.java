package com.demo181108.userdemo.dao;

import com.demo181108.userdemo.domain.TranslateRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface TranslateRecordDao {

    int selectCount();

    int addTranslateRecord(TranslateRecord record);

    List<TranslateRecord> findByPage(HashMap<String ,Object> map);

    int selectCountByUserId(String user_id);
}
