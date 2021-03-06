package com.gpj.dao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.gpj.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationDao extends BaseMapper<Consultation> {
    //
    void selectList(PageQuery<Consultation> page);
}