package com.gpj.controller.admin;

import com.gpj.dao.RegistrationDao;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private RegistrationDao registrationDao;

    @RequestMapping("/registrationManage")
    public String manage(PatientQueryResult patientQueryResult, Model model) {
        //查询预约记录
        PageQuery<Registration> page = registrationService.findList(patientQueryResult);
        System.out.println(page);
        model.addAttribute("page", page);
        model.addAttribute("pageNum", patientQueryResult.getPageNum());
        model.addAttribute("patientName", patientQueryResult.getPatientName());
        model.addAttribute("doctorName", patientQueryResult.getDoctorName());
        return "registrationManage";
    }
    @RequestMapping("/registrationForm")
    public String patientForm(){
        return "registrationForm";
    }
    @ResponseBody
    @RequestMapping("/registrationDelete")
    public ResponseResult delete(Integer id){
        int rows = registrationService.deleteRegistration(id);
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
    @RequestMapping("/registrationSave")
    public String save(Registration registration){
        registrationService.saveRegistration(registration);
        return "redirect:registrationManage";

    }

    @RequestMapping("/registrationModify")
    public String test(@RequestParam("id") long id, Model model){
        model.addAttribute("registration",registrationDao.single(id));
        return "registrationForm1";
    }
    @RequestMapping("/registrationEdit")
    public String edit(Registration registration){
        registrationService.editRegistration(registration);
        return "redirect:registrationManage";
    }
}
