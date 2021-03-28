package com.gpj.controller.doctor;

import com.gpj.dao.DoctorDao;
import com.gpj.entity.Authority;
import com.gpj.entity.Doctor;
import com.gpj.entity.Patient;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.DoctorService;
import com.gpj.service.PatientService;
import com.gpj.service.RegistrationService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorUserController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SQLManager sqlManager;

    @RequestMapping("/index")
    public String index(PatientQueryResult patientQueryResult, HttpSession session,Model model){
        Authority authority = (Authority)session.getAttribute("authority");
        PageQuery <Patient> page = patientService.findPatientList(patientQueryResult);
        model.addAttribute("page",page);
        return "doctorIndex";
    }

    //根据部门查询医生
@ResponseBody
@RequestMapping(value = "/getList")
public List<Doctor> getList(@RequestParam String department){
    return doctorService.getListByDepartment(department);
}


}
