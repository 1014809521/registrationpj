package com.gpj.result;

import lombok.Data;

//处理json响应
@Data
public class ResponseResult {
    private String code;
    private String msg;
}
