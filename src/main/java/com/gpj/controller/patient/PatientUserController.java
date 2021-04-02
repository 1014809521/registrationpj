package com.gpj.controller.patient;

import com.gpj.dao.PatientDao;
import com.gpj.entity.*;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.ConsultationService;
import com.gpj.service.PatientService;
import com.gpj.service.RegistrationService;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patient")
//显示预约记录
public class PatientUserController {
    @Autowired
    private SQLManager sqlManager;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private ConsultationService consultationService;
    @RequestMapping("/index")
    public String index(
            HttpSession session, PatientQueryResult patientQueryResult,Model model){
        //查询预约记录
        Authority authority = (Authority) session.getAttribute("authority");
        System.out.println(authority.getId());
        patientQueryResult.setUserId(authority.getId());
        System.out.println(patientQueryResult.getPageNum());

        PageQuery<Registration> page = registrationService.findList(patientQueryResult);
        List<Registration> list = page.getList();
        model.addAttribute("list",list);
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
        Integer registrationId = registrationService.returnID(registration);
        Patient patient = new Patient();
        patient.setId(registration.getPatientId());
        patient.setRegistrationId(registrationId);
        patientService.editPatient(patient);
        ResponseResult result = new ResponseResult();
        result.setMsg("成功");
        result.setCode("100");
        return result;

    }
    @RequestMapping("/consult")
    public String seek(HttpSession session,Model model){
        Authority authority = (Authority) session.getAttribute("authority");
        Patient patient = patientService.findByUserId(authority.getId());
        model.addAttribute("patient",patient);
        return "consult";
    }
    @ResponseBody
    @RequestMapping("/consultInfo")
    public ResponseResult seekInfo(@RequestBody Map map){
        return consultationService.save(map);
    }
    @RequestMapping("/consultation")
    public String consultation(
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "5") Integer pageSize,
            HttpSession session,Model model){
        //查询预约记录
        Authority authority = (Authority) session.getAttribute("authority");
        Patient patient = patientService.findByUserId(authority.getId());
        PageQuery<Consultation> page = consultationService.findConsultList(pageNum,pageSize,patient.getId());
        model.addAttribute("page",page);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("patientId",patient.getId());
        return "consultation";
    }
}
