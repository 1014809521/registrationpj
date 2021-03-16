package com.gpj.service.Implements;

import com.gpj.dao.DoctorDao;
import com.gpj.entity.Doctor;
import com.gpj.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Override
    public List<Doctor> findDoctorList() {
        return doctorDao.all();
    }
}
