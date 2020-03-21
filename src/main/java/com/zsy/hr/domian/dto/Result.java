package com.zsy.hr.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Result
 * @Description TODO
 * @Date 2020/3/21 16:14
 * @Created by Yinghao.He
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T domain;
    private static Result setOk(){
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMessage("ok");
        return result;
    }
    private static Result setFail(){
        Result<Object> result = new Result<>();
        result.setCode(500);
        return result;
    }
    public static Result ok(){
        return setOk();
    }
    public static Result ok(Object domain){
        Result result = setOk();
        result.setDomain(domain);
        return result;
    }
    public static Result fail(){
        Result result = setFail();
        result.setMessage("fail");
        return result;
    }
    public static Result fail(String message){
        Result result = setFail();
        result.setMessage(message);
        return result;
    }

}
