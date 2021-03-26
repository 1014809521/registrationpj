package com.gpj.controller.patient;

import com.gpj.entity.Authority;
import com.gpj.entity.Patient;
import com.gpj.entity.Registration;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.PatientService;
import com.gpj.service.RegistrationService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/patient")
//显示预约记录
public class PatientUserController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private PatientService patientService;
    @RequestMapping("/index")
    public String index(
            HttpSession session, PatientQueryResult patientQueryResult,Model model){
        //查询预约记录
        Authority authority = (Authority) session.getAttribute("authority");
        System.out.println(authority.getId());
        patientQueryResult.setUserId(authority.getId());
        System.out.println(patientQueryResult.getPageNum());
        PageQuery<Registration> page = registrationService.findList(patientQueryResult);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",patientQueryResult.getPageNum());
        return "appointmentHistory";
    }
    //预约表单
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String form(HttpSession session,Model model){
        Authority authority = (Authority) session.getAttribute("authority");
        Patient patient = patientService.findByUserId(authority.getId());
        model.addAttribute("patient",patient);
        return "registrationForm3";
    }
    //预约保存
    @ResponseBody
    @RequestMapping(value = "/registration1",method = RequestMethod.POST)
    public ResponseResult save(@RequestBody Registration registration){
        return registrationService.createRegistration(registration);

    }
}
