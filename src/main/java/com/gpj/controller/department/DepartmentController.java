package com.gpj.controller.department;

import com.gpj.dao.DepartmentDao;
import com.gpj.entity.Department;
import com.gpj.entity.Doctor;
import com.gpj.entity.Patient;
import com.gpj.result.ResponseResult;
import com.gpj.service.DepartmentService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private SQLManager sqlManager;
    @RequestMapping("/departmentManage")
    public String departmentManage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                @RequestParam(required = false)String name,
                                Model model){
        //查询医生数据

        PageQuery<Department> page = departmentService.findDepartmentList(pageNum,pageSize,name);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("name",name);
        return "departmentManage";
    }
    @RequestMapping("/departmentForm")
    public String departmentForm(){
        return "departmentForm";
    }
    @ResponseBody
    @RequestMapping("/departmentDelete")
    public ResponseResult delete(Integer id){
        int rows = departmentService.deleteDepartment(id);
        ResponseResult result = new ResponseResult();
        if (rows>0){
            result.setCode("400");
            result.setMsg("删除成功");
        }
        else {
            result.setCode("401");
            result.setMsg("删除失败");
        }
        return result;
    }
    @RequestMapping("/departmentSave")
    public String save(Department department){
        departmentService.saveDepartment(department);
        return "redirect:departmentManage";

    }

    @RequestMapping("/departmentModify")
    public String test(@RequestParam("id") long id,Model model){
        model.addAttribute("department",departmentDao.single(id));
        return "departmentForm1";
    }
    @RequestMapping("/departmentEdit")
    public String edit(Department department){
        departmentService.editDepartment(department);
        return "redirect:departmentManage";
    }
    @ResponseBody
    @RequestMapping(value = "/getDepartmentList")
    public List<Department> getList(){
        return departmentDao.all();
    }
    @RequestMapping("/departmentInfo")
    public String information(){
        return "departmentInformation";
    }
    @ResponseBody
    @RequestMapping("/findDepartmentByName")
    public Department getList1(@RequestParam("name")String name){
        System.out.println(departmentService.findDepartmentList(1,5,name).getList().get(0).getType());
        return(departmentService.findDepartmentList(1,5,name).getList().get(0));
    }

}

