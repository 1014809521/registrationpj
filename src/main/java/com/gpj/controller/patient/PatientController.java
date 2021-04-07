package com.gpj.controller.patient;

import com.gpj.dao.PatientDao;
import com.gpj.entity.Patient;
import com.gpj.entity.Patient;
import com.gpj.entity.Patient;
import com.gpj.result.PatientQueryResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.PatientService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private SQLManager sqlManager;
    @RequestMapping("/patientManage")
    public String patientManage(PatientQueryResult patientQueryResult,
                                @RequestParam(required = false)String name,
                               Model model){
        //查询患者数据

        patientQueryResult.setPatientName(name);
        PageQuery<Patient> page = patientService.findPatientList(patientQueryResult);

            model.addAttribute("page",page);
            model.addAttribute("pageNum",patientQueryResult.getPageNum());
            model.addAttribute("name",patientQueryResult.getPatientName());
        return "patientManage";
    }
    @RequestMapping("/patientForm")
    public String patientForm(){
        return "patientForm";
    }
    @ResponseBody
    @RequestMapping("/patientDelete")
    public ResponseResult delete(Integer id){
        int rows = patientService.deletePatient(id);
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
    @RequestMapping("/patientSave")
    public String save(Patient patient){
        patientService.savePatient(patient);
        return "redirect:patientManage";

    }

    @RequestMapping("/patientModify")
    public String test(@RequestParam("id") long id,Model model){
        model.addAttribute("patient",patientDao.single(id));
        return "patientForm1";
    }
    @RequestMapping("/patientEdit")
    public String edit(Patient patient){
        patientService.editPatient(patient);
        return "redirect:patientManage";
    }
}
