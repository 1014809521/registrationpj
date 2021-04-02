package com.gpj.service;

import com.gpj.entity.Patient;
import com.gpj.entity.Seek;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface SeekService {
    //保存记录
    ResponseResult save(Map map);
    PageQuery<Seek> findSeekList(long pageNum, long pageSize,Integer patientId);
}
