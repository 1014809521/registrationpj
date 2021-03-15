package com.gpj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/index")
    public String index(){
        //读取医生的信息
        return "index";
    }
}
