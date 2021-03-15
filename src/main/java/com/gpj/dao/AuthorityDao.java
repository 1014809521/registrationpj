package com.gpj.dao;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;
import com.gpj.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

@Repository
public interface AuthorityDao extends BaseMapper<Authority> {
    //查询用户
    Authority findUserByName(@Param("name") String name);
}