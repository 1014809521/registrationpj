package com.gpj.service.Implements;

import com.gpj.dao.DoctorDao;
import com.gpj.entity.Doctor;
import com.gpj.result.ResponseResult;
import com.gpj.service.DoctorService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.LambdaQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SQLManager sqlManager;
    @Override
    public List<Doctor> findDoctorList(Integer pageNum, Integer pageSize,String name) {
        PageQuery<Doctor> queryOfFindPage = new PageQuery<>();
        queryOfFindPage.setPageNumber(pageNum);//设置当前页码
        queryOfFindPage.setPageSize(pageSize);//设置查询数量
        doctorDao.templatePage(queryOfFindPage);//进行分页查询，调用dao对象继承BaseMapp父类的方法'templatePage()'，传入参数为此前创建的PageQuery对象名。
        List<Doctor> list = queryOfFindPage.getList();

        if(pageNum >0 &&pageSize>0){
            return list;
        }
        return null;
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorDao.insert(doctor);

    }

    @Override
    public void editDoctor(Doctor doctor) {
        doctorDao.updateTemplateById(doctor);
    }

    @Override
    public int deleteDoctor(int id) {
        return doctorDao.deleteById(id);
    }

    @Override
    public List<Doctor> getListByDepartment(String department) {
        Query<Doctor>query = doctorDao.createQuery();
        query.andEq("department",department);
        return query.select();
    }


}
