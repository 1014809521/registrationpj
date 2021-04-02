package com.gpj.dao;
import org.beetl.sql.core.annotatoin.*;
import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.gpj.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekDao extends BaseMapper<Seek> {
    //
    void selectList(PageQuery<Seek> page);
}