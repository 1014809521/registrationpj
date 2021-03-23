package com.gpj.service;

import com.gpj.entity.Registration;
import com.gpj.entity.Registration;
import com.gpj.result.PatientQueryResult;
import org.beetl.sql.core.engine.PageQuery;

public interface RegistrationService {
    PageQuery<Registration> findList(PatientQueryResult patientQueryResult);
    void saveRegistration(Registration registration);
    void editRegistration(Registration registration);
    int deleteRegistration(int id);
}
