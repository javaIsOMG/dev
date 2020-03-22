package com.zsy.hr.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
 * @Created by yuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String msg;
    private T obj;
    private Integer status;
    private static Result setOk(){
        Result<Object> result = new Result<>();
        result.setStatus(200);
        result.setMsg("登录成功");
        return result;
    }
    private static Result setFail(){
        Result<Object> result = new Result<>();
        return result;
    }
    public static Result ok(){
        return setOk();
    }
    public static Result ok(Object domain){
        Result result = setOk();
        result.setObj(domain);
        return result;
    }
    public static Result fail(){
        Result result = setFail();
        result.setMsg("fail");
        return result;
    }
    public static Result fail(String message){
        Result result = setFail();
        result.setMsg(message);
        return result;
    }

}
