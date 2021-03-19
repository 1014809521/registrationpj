package com.gpj.dao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.gpj.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends BaseMapper<Patient> {
    //查询病人主治医师
    void selectList(PageQuery<Patient> page);
}