package com.gpj.dao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.gpj.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnDao extends BaseMapper<Return> {
    void selectList(PageQuery<Return> page);
    //
}