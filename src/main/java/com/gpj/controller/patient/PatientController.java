package com.gpj.controller.patient;

import com.gpj.dao.DoctorDao;
import com.gpj.entity.Doctor;
import com.gpj.service.DoctorService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PatientController {
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
        Query<Doctor> query = sqlManager.query((Doctor.class));
        List<Doctor> findall = query.select();
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
    }}
