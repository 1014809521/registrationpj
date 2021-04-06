package com.gpj.service.Implements;

import com.gpj.dao.ReturnDao;
import com.gpj.entity.Return;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.ReturnService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnDao return1Dao;
    @Override
    public ResponseResult save(Map map) {
        Return return1 = new Return();
        return1.setPatientId((Integer.valueOf(String.valueOf(map.get("patientId")))));
        return1.setDoctorId(Integer.valueOf(String.valueOf(map.get("doctorId"))));
        return1.setRegistrationId(Integer.valueOf(String.valueOf(map.get("registrationId"))));
        return1.setQuestion(String.valueOf(map.get("question")));
        return1Dao.insert(return1);
        ResponseResult result = new ResponseResult();
        result.setCode("100");
        result.setMsg("成功");
        return result;
    }

    @Override
    public PageQuery<Return> findList(PatientQueryResult patientQueryResult) {
        PageQuery<Return> query = new PageQuery<>();
        if(!StringUtils.isEmpty(patientQueryResult.getDoctorId())){
        query.setPara("doctorId", patientQueryResult.getDoctorId());
        }
        if(!StringUtils.isEmpty(patientQueryResult.getPatientName())){
            query.setPara("patientName", patientQueryResult.getPatientName());
        }
        if(!StringUtils.isEmpty(patientQueryResult.getRegistrationId())){
            query.setPara("registrationId", patientQueryResult.getRegistrationId());
        }
        return1Dao.selectList(query);
        return query;
    }

    @Override
    public void editReturn(Return return1) {
        return1Dao.updateTemplateById(return1);
    }
}
