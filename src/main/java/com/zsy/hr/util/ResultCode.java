package com.zsy.hr.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: Hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-21 19:04
 */
@AllArgsConstructor
@Getter
public enum  ResultCode {
    LOGIN_FAIL(500,"密码或者账号错误");
    private Integer code;
    private String message;
}
