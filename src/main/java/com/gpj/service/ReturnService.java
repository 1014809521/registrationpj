package com.gpj.service;

import com.gpj.entity.Return;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

import java.util.Map;

public interface ReturnService {
    ResponseResult save(Map map);
    PageQuery<Return> findList(PatientQueryResult patientQueryResult);
    void editReturn(Return return1);
}
