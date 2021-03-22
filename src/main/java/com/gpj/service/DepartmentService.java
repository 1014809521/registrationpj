package com.gpj.service;

import com.gpj.entity.Department;
import com.gpj.entity.Department;
import org.beetl.sql.core.engine.PageQuery;

public interface DepartmentService {
    PageQuery<Department> findDepartmentList(long pageNum, long pageSize, String name);
    void saveDepartment(Department department);
    void editDepartment(Department department);
    int deleteDepartment(int id);
}
