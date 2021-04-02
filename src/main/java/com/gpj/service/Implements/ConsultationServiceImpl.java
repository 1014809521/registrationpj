package com.gpj.service.Implements;

import com.gpj.dao.ConsultationDao;
import com.gpj.entity.Consultation;
import com.gpj.entity.Seek;
import com.gpj.result.ResponseResult;
import com.gpj.service.ConsultationService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private ConsultationDao consultationDao;
    @Override
    public ResponseResult save(Map map) {
        Consultation consultation = new Consultation();
        consultation.setPatientId((Integer.valueOf(String.valueOf(map.get("patientId")))));
        consultation.setDays(String.valueOf(map.get("days")));
        consultation.setDescribes(String.valueOf(map.get("describes")));
        consultation.setDoctorId(Integer.valueOf(String.valueOf(map.get("doctorId"))));
        consultationDao.insert(consultation);
        ResponseResult result = new ResponseResult();
        result.setCode("100");
        result.setMsg("成功");
        return result;
    }

    @Override
    public PageQuery<Consultation> findConsultList(long pageNum, long pageSize, Integer patientId) {
        PageQuery<Consultation> query = new PageQuery<>();
        query.setPara("patientId", patientId);
        consultationDao.selectList(query);
        return query;
    }
}
