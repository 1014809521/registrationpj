package com.gpj.controller.home;


import com.gpj.entity.Authority;
import com.gpj.result.ActiveResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class LoginController {
    @Autowired
    private AuthorityService authorityService;
    //登录页面
    @RequestMapping("/loginRegisterPage")
    public String loginRegisterPage() {

        return "loginRegister";
    }
    //请求登录
    @ResponseBody
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody Authority authority, HttpSession session){
        return authorityService.check(authority,session);
    }
    //注册
    @ResponseBody
    @RequestMapping("register")
    public ResponseResult register(@RequestBody ActiveResult activeResult){
        return authorityService.register(activeResult);
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/home/loginRegisterPage";
    }


}
