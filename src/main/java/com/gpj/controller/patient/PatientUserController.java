package com.gpj.controller.patient;

import com.gpj.entity.Authority;
import com.gpj.entity.Registration;
import com.gpj.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/patient")
//显示预约记录
public class PatientUserController {
    @Autowired
    private RegistrationService registrationService;
    @RequestMapping("/index")
    public String index(HttpSession session, Model model){
        //查询预约记录
        Authority authority = (Authority) session.getAttribute("authority");

        return "appointmentHistory";
    }
}
