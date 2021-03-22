package com.gpj.service.Implements;

import com.gpj.dao.DoctorDao;
import com.gpj.dao.PatientDao;
import com.gpj.entity.Doctor;
import com.gpj.entity.Patient;
import com.gpj.service.DoctorService;
import com.gpj.service.PatientService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PaitientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private SQLManager sqlManager;



    @Override
    public PageQuery<Patient> findPatientList(long pageNum, long pageSize, String name) {

        PageQuery<Patient> query = new PageQuery(pageNum,pageSize);
        if(!StringUtils.isEmpty(name)){
            query.setPara("name",'%'+name+'%');
        }
//        queryOfFindPage.setPageNumber(pageNum);//设置当前页码
//        queryOfFindPage.setPageSize(pageSize);//设置查询数量
//        patientDao.templatePage(queryOfFindPage);//进行分页查询，调用dao对象继承BaseMapp父类的方法'templatePage()'，传入参数为此前创建的PageQuery对象名。
//        List<Patient> list = queryOfFindPage.getList();
        patientDao.selectList(query);
        return query;
    }

    @Override
    public void savePatient(Patient patient) {
        patientDao.insert(patient);
    }

    @Override
    public void editPatient(Patient patient) {
        patientDao.updateTemplateById(patient);

    }

    @Override
    public int deletePatient(int id) {
        return patientDao.deleteById(id);
    }
}
