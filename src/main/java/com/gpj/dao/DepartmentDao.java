package com.gpj.dao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.gpj.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends BaseMapper<Department> {
    //
    void selectList(PageQuery<Department> page);
}