package com.gpj.service.Implements;

import com.gpj.dao.RegistrationDao;
import com.gpj.entity.Patient;
import com.gpj.entity.Registration;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.RegistrationService;
import org.apache.tomcat.jni.Global;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.spi.RegisterableService;
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationDao registrationDao;
    @Override
    public PageQuery<Registration> findList(PatientQueryResult patientQueryResult) {
        PageQuery<Registration> query = new PageQuery(patientQueryResult.getPageNum(),patientQueryResult.getPageSize());
        if(!StringUtils.isEmpty(patientQueryResult.getPatientName())){
            query.setPara("patientName",patientQueryResult.getPatientName());
        }
        if(!StringUtils.isEmpty(patientQueryResult.getDoctorName())){
            query.setPara("doctorName",patientQueryResult.getDoctorName());
        }
        if(patientQueryResult.getUserId()!=null){
            query.setPara("userId",patientQueryResult.getUserId());
        }
//        queryOfFindPage.setPageNumber(pageNum);//设置当前页码
//        queryOfFindPage.setPageSize(pageSize);//设置查询数量
//        patientDao.templatePage(queryOfFindPage);//进行分页查询，调用dao对象继承BaseMapp父类的方法'templatePage()'，传入参数为此前创建的PageQuery对象名。
//        List<Patient> list = queryOfFindPage.getList();
//        query.setOrderBy("a.id desc");
        registrationDao.selectList(query);
        return query;
    }

    @Override
    public void saveRegistration(Registration registration) {
        registrationDao.insert(registration);
    }

    @Override
    public void editRegistration(Registration registration) {
        registrationDao.updateTemplateById(registration);

    }

    @Override
    public int deleteRegistration(int id) {
        return registrationDao.deleteById(id);
    }

    @Override
    public ResponseResult createRegistration(Registration registration) {
        ResponseResult result = new ResponseResult();
        registrationDao.insert(registration);
        result.setCode("100");
        result.setMsg("成功");
        return result;
    }

    @Override
    public Integer returnID(Registration registration) {
        return registrationDao.insertReturnKey(registration).getInt();
    }

}
