package com.gpj.service;

import com.gpj.entity.Doctor;
import com.gpj.result.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

public interface DoctorService {
    List<Doctor> findDoctorList(Integer pageNum, Integer pageSize,String name);
    void saveDoctor(Doctor doctor);
    void editDoctor(Doctor doctor);
    int deleteDoctor(int id);
}
