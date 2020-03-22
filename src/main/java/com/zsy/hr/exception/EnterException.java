package com.zsy.hr.exception;

/**
 * @program: Hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-21 19:34
 */
public class EnterException extends RuntimeException{
    private Integer code;
    private String message;

    public EnterException(Integer code,String message) {
        this.message = message;
        this.code=code;
    }
}
