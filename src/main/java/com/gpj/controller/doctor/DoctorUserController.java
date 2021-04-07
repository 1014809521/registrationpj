package com.gpj.controller.doctor;

import com.baomidou.mybatisplus.extension.api.R;
import com.gpj.dao.*;
import com.gpj.entity.*;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.*;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
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
    private ReturnDao returnDao;
    @Autowired
    private SeekDao seekDao;
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private ConsultationDao consultationDao;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private ReturnService returnService;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SQLManager sqlManager;

    @RequestMapping("/index")
    public String index(PatientQueryResult patientQueryResult, HttpSession session,Model model){
        Authority authority = (Authority)session.getAttribute("authority");
        Doctor doctor = doctorService.findByUserId(authority.getId());
        patientQueryResult.setDoctorId(doctor.getId());
        PageQuery <Registration> page = registrationService.findList(patientQueryResult);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",patientQueryResult.getPageNum());
        return "doctorIndex";
    }
    @RequestMapping("/consult")
    public String consult(
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "5") Integer pageSize,
            HttpSession session,Model model){
        //查询预约记录
        Authority authority = (Authority) session.getAttribute("authority");
        Doctor doctor = doctorService.findByUserId(authority.getId());
        PageQuery<Consultation> page = consultationService.findConsultList1(pageNum,pageSize,doctor.getId());
        model.addAttribute("page",page);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("doctorId",doctor.getId());
        return "consultation1";
    }
    @RequestMapping("/consultModify")
    public String test(@RequestParam("id") long id,Model model){
        model.addAttribute("consult",consultationDao.single(id));
        return "consultForm1";
    }
    @RequestMapping("/consultEdit")
    public String edit(Consultation consultation){
        consultationService.editConsult(consultation);
        return "redirect:index";
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

//    @RequestMapping("/return1")
//    public String return1(@RequestParam("id")Integer id, @RequestParam(required = false, defaultValue = "1") Integer pageNum,
//                          @RequestParam(required = false, defaultValue = "5") Integer pageSize,Model model){
//        PageQuery<Seek> page = seekService.findSeekList1(pageNum,pageSize,id);
//        model.addAttribute("page",page);
//        model.addAttribute("pageNum",pageNum);
//        model.addAttribute("registrationId",id);
//        return "return";
//    }
    @RequestMapping("/return1")
    public String test2(@RequestParam("id") int id,
                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "5") Integer pageSize,Model model){
        Registration registration = registrationDao.single(id);
//        PageQuery<Seek> page = seekService.findSeekList(pageNum,pageSize,registration.getPatientId());
        Return return1 = new Return();
        return1.setDoctorId(registration.getDoctorId());
        return1.setRegistrationId(id);
        return1.setPatientId(registration.getPatientId());
//        Seek seek = (Seek) page.getParas();
        model.addAttribute("return1",return1);
//        model.addAttribute("page",seek);
        return "return";
    }
    @ResponseBody
    @RequestMapping("/returnEdit")
    public ResponseResult edit(@RequestBody Map map){
//        System.out.println(map);

        return returnService.save(map);
    }

    @RequestMapping("/returnList")
    public String returnList( @RequestParam("id") int id, HttpSession session,Model model){
        Authority authority = (Authority)session.getAttribute("authority");
        PatientQueryResult patientQueryResult = new PatientQueryResult();
        Doctor doctor = doctorService.findByUserId(authority.getId());
        patientQueryResult.setDoctorId(doctor.getId());
        patientQueryResult.setRegistrationId(id);
        PageQuery <Return> page = returnService.findList(patientQueryResult);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",patientQueryResult.getPageNum());
        return "doctorReturn";
    }

    //根据部门查询医生
@ResponseBody
@RequestMapping(value = "/getList")
public List<Doctor> getList(@RequestParam String department){
    return doctorService.getListByDepartment(department);
}
//    @ResponseBody
//    @RequestMapping(value = "/getList1")
//    public List<Doctor> getList1(@RequestParam String doctor){
//        return doctorService.getListByDepartment(department);
//    }


}




