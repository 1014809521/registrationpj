package com.gpj.service;

import com.gpj.entity.Authority;
import com.gpj.result.ActiveResult;
import com.gpj.result.ResponseResult;

import javax.servlet.http.HttpSession;

public interface AuthorityService {
    //登录校验
    ResponseResult check(Authority authority, HttpSession session);
    //注册用户
    ResponseResult register(ActiveResult activeResult);
}
