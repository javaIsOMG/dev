package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.vo.HrVo;
import com.zsy.hr.service.LoginService;
import com.zsy.hr.util.ResultCode;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
 * @Created by yuan
 */
@Slf4j
@Api
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public Result login(@Valid HrVo hrVo){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken();
        usernamePasswordToken.setUsername(hrVo.getUsername());
        //将账号密码放入主体中
        usernamePasswordToken.setPassword(hrVo.getPassword().toCharArray());
        try{
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            String message = e.getMessage();
            log.info(message);
            return Result.fail(message);
        }
        return Result.ok(loginService.GetUserName( hrVo.getUsername() ) );
    }
}
