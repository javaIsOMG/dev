package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.vo.HrVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
 * @Created by Yinghao.He
 */
@Slf4j
@RestController
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@Valid HrVo hrVo){
        return Result.ok();
    }
}
