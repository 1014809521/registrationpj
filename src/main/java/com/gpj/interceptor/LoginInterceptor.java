package com.gpj.interceptor;

import com.gpj.entity.Authority;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Authority authority = (Authority)session.getAttribute("authority");
        if(authority==null){
            response.sendRedirect(request.getContextPath()+"/home/loginRegisterPage");
            return false;
        }
        return true;
    }
}
