package com.gpj.service;

import com.gpj.entity.Consultation;
import com.gpj.entity.Seek;
import com.gpj.result.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface ConsultationService {
    ResponseResult save(Map map);
    PageQuery<Consultation> findConsultList(long pageNum, long pageSize, Integer patientId);
}
