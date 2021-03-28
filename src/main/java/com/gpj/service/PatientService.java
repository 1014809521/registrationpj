package com.gpj.service;

import com.gpj.entity.Patient;
import com.gpj.entity.Patient;
import com.gpj.result.PatientQueryResult;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

public interface PatientService {
    PageQuery<Patient> findPatientList(PatientQueryResult patientQueryResult);
    void savePatient(Patient patient);
    void editPatient(Patient patient);
    int deletePatient(int id);
    //根据用户id获取患者信息
    Patient findByUserId(Integer userId);
}
