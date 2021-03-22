package com.gpj.service.Implements;

import com.gpj.dao.DepartmentDao;
import com.gpj.entity.Department;
import com.gpj.entity.Department;
import com.gpj.service.DepartmentService;
import com.itextpdf.text.PageSize;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private SQLManager sqlManager;



    @Override
    public PageQuery<Department> findDepartmentList(long pageNum, long pageSize, String name) {

        PageQuery<Department> query = new PageQuery(pageNum,pageSize);
        if(!StringUtils.isEmpty(name)){
            query.setPara("name",'%'+name+'%');
        }
        departmentDao.selectList(query);
//        queryOfFindPage.setPageNumber(pageNum);//设置当前页码
//        queryOfFindPage.setPageSize(pageSize);//设置查询数量
//        departmentDao.templatePage(queryOfFindPage);//进行分页查询，调用dao对象继承BaseMapp父类的方法'templatePage()'，传入参数为此前创建的PageQuery对象名。
//        List<Department> list = queryOfFindPage.getList();;

        return query;
    }

    @Override
    public void saveDepartment(Department department) {
        departmentDao.insert(department);
    }

    @Override
    public void editDepartment(Department department) {
        departmentDao.updateTemplateById(department);

    }

    @Override
    public int deleteDepartment(int id) {
        return departmentDao.deleteById(id);
    }
}
