package com.gpj.controller.doctor;

import com.gpj.dao.DoctorDao;
import com.gpj.entity.Doctor;
import com.gpj.result.ResponseResult;
import com.gpj.service.DoctorService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorUserController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SQLManager sqlManager;
    @RequestMapping("/doctorManage")
    public String doctorManage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                               @RequestParam(required = false)String name,
                               Model model){
        //查询医生数据
        Query<Doctor>query = sqlManager.query((Doctor.class));
        List<Doctor>findall = query.select();
        List<Doctor> page = doctorService.findDoctorList(pageNum,pageSize,name);
        if(!StringUtils.isEmpty(name)){
            findall = query.andLike("name",'%'+name+'%').select();
            model.addAttribute("count1",findall.size());
            model.addAttribute("page",findall);
            model.addAttribute("pageNum",pageNum);
        }
        else{
        model.addAttribute("count1",findall.size());
        model.addAttribute("page",page);
        model.addAttribute("pageNum",pageNum);}
        return "doctorManage";
    }
    @RequestMapping("/doctorForm")
    public String doctorForm(){
        return "doctorForm";
    }
    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult delete(Integer id){
        int rows = doctorService.deleteDoctor(id);
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
    @RequestMapping("/doctorSave")
    public String save(Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:doctorManage";

    }

    @RequestMapping("/modify")
    public String test(@RequestParam("id") long id,Model model){
        model.addAttribute("doctor",doctorDao.single(id));
        return "doctorForm1";
    }
    @RequestMapping("/doctorEdit")
    public String edit(Doctor doctor){
        doctorService.editDoctor(doctor);
        return "redirect:doctorManage";
    }

//    @RequestMapping("/modify/{id}")
//    public String doctorForm1(@PathVariable long id,Model model){
//        model.addAttribute("doctor",doctorDao.single(id));
//        return "doctorForm1";
//    }
    //根据部门查询医生
@ResponseBody
@RequestMapping(value = "/getList")
public List<Doctor> getList(@RequestParam String department){
    return doctorService.getListByDepartment(department);
}






}
