package com.gpj.controller.doctor;

import com.gpj.dao.DoctorDao;
import com.gpj.dao.PatientDao;
import com.gpj.dao.RegistrationDao;
import com.gpj.entity.*;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.DoctorService;
import com.gpj.service.PatientService;
import com.gpj.service.RegistrationService;
import com.gpj.service.SeekService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;

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
    private SeekService seekService;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SQLManager sqlManager;

    @RequestMapping("/index")
    public String index(PatientQueryResult patientQueryResult, HttpSession session,Model model){
        Authority authority = (Authority)session.getAttribute("authority");
        PageQuery <Registration> page = registrationService.findList(patientQueryResult);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",patientQueryResult.getPageNum());
        return "doctorIndex";
    }
    @RequestMapping("/medicalHistory")
    public String medicalHistory(@RequestParam("id") Integer patientId,
                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize,Model model) {
        System.out.println(patientId);
        PageQuery<Seek> page = seekService.findSeekList(pageNum,pageSize,patientId);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("patientId",patientId);
        return "medicalHistory";
    }
    //就医页面
    @RequestMapping("/seek")
    public String seek(@RequestParam("id")Integer id,@RequestParam("rid") Integer rid, Model model){
        Registration registration = new Registration();
        registration.setId(rid);
        registration.setStatus("2");
        registrationDao.updateTemplateById(registration);
        model.addAttribute("patient",patientDao.single(id));
        return "seek";
    }
    @ResponseBody
    @RequestMapping("/finishSeek")
    public ResponseResult finishSeek(@RequestParam("id")Integer id) {
        Registration registration = new Registration();
        registration.setId(id);
        registration.setStatus("3");
        registrationService.editRegistration(registration);
        ResponseResult result = new ResponseResult();
        result.setMsg("成功");
        result.setCode("100");
        return  result;
    }
    @ResponseBody
    @RequestMapping("/seekInfo")
    public ResponseResult seekInfo(@RequestBody Map map){
        return seekService.save(map);
    }


    //根据部门查询医生
@ResponseBody
@RequestMapping(value = "/getList")
public List<Doctor> getList(@RequestParam String department){
    return doctorService.getListByDepartment(department);
}


}
