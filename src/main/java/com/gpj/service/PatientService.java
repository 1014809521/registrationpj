package com.gpj.service;

import com.gpj.entity.Patient;
import com.gpj.entity.Patient;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

public interface PatientService {
    PageQuery<Patient> findPatientList(long pageNum, long pageSize, String name);
    void savePatient(Patient patient);
    void editPatient(Patient patient);
    int deletePatient(int id);
}
