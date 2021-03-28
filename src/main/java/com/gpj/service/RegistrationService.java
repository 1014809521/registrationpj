package com.gpj.service;

import com.gpj.entity.Registration;
import com.gpj.entity.Registration;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

public interface RegistrationService {
    PageQuery<Registration> findList(PatientQueryResult patientQueryResult);
    void saveRegistration(Registration registration);
    void editRegistration(Registration registration);
    int deleteRegistration(int id);
    //病人预约
    ResponseResult createRegistration(Registration registration);
    //插入返回主键
    Integer returnID(Registration registration);
}
