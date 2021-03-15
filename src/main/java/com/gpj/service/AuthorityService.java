package com.gpj.service;

import com.gpj.entity.Authority;
import com.gpj.result.ActiveResult;
import com.gpj.result.ResponseResult;
public interface AuthorityService {
    //登录校验
    ResponseResult check(Authority authority);
    //注册用户
    ResponseResult register(ActiveResult activeResult);
}
