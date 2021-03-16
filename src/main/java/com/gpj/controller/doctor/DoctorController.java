package com.gpj.controller.doctor;

import com.gpj.entity.Doctor;
import com.gpj.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/doctorManage")
    public String doctorManage(Model model){
        //查询医生数据
        List<Doctor> list = doctorService.findDoctorList();
        model.addAttribute("list",list);
        return "doctorManage";
    }
}
