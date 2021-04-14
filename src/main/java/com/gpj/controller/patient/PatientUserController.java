package com.gpj.controller.patient;

import com.gpj.dao.*;
import com.gpj.entity.*;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.beetl.sql.core.DSTransactionManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

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
    private DoctorService doctorService;
    @Autowired
    private ReturnDao returnDao;
    @Autowired
    private ReturnService returnService;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SeekService seekService;
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
        model.addAttribute("list", list);
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
        Date date = registration.getTime();
        date.setHours(date.getHours()-8);
        registration.setTime(date);
        registration.setExpenses(BigDecimal.valueOf((int)doctorDao.single(registration.getDoctorId()).getPrice()));
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
    @RequestMapping("/returnList")
    public String consult(@RequestParam("id" )int id,
            HttpSession session,Model model){
        //查询预约记录
        Authority authority = (Authority) session.getAttribute("authority");
        Patient patient = patientService.findByUserId(authority.getId());
        PatientQueryResult patientQueryResult = new PatientQueryResult();
        patientQueryResult.setRegistrationId(id);
        PageQuery<Return> page = returnService.findList(patientQueryResult);
        model.addAttribute("page",page);
        model.addAttribute("pageNum",patientQueryResult.getPageNum());
        return "patientReturn";
    }
    @RequestMapping("/returnModify")
    public String test(@RequestParam("id") int id,Model model){
        model.addAttribute("return1",returnDao.single(id));
        return "returnForm";
    }
    @RequestMapping("/returnEdit")
    public String edit(Return return1){
        returnService.editReturn(return1);
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/getDepartmentList")
    public List<Department> getList(){
        return departmentDao.all();
    }
    @RequestMapping("/departmentInfo")
    public String information(){
        return "departmentInformation";
    }
    @ResponseBody
    @RequestMapping("/findDepartmentByName")
    public Department getList1(@RequestParam("name")String name){
        System.out.println(departmentService.findDepartmentList(1,5,name).getList().get(0).getType());
        return(departmentService.findDepartmentList(1,5,name).getList().get(0));
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
    @RequestMapping("/information")//医生信息
    public String doctorInformation(){
        return "doctorInformation";
    }
    @ResponseBody
    @RequestMapping(value = "/getList")//获得医生列表
    public List<Doctor> getList(@RequestParam String department){
        return doctorService.getListByDepartment(department);
    }
    @ResponseBody
    @RequestMapping("/cancel")//取消预约
    public String cancel(@RequestParam("id")Integer id) {
        Registration registration = registrationDao.single(id);
        registration.setStatus("4");
        registrationDao.upsertByTemplate(registration);
        ResponseResult result = new ResponseResult();
        result.setMsg("成功");
        result.setCode("100");
        return result.getMsg();


    }
}
