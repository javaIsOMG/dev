package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Employee;
import com.zsy.hr.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @Classname EmployeeController
 * @Description TODO
 * @Date 2020/3/23 15:24
 * @Created by Yinghao.He
 */
@RestController
@RequestMapping(value = "/employee/basic")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Result getEmployeeInfo(@RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "10")Integer size,
                                  @Valid Employee employee,
                                   Date[] beginDateScope){
        return employeeService.getEmployeeInfo(page,size,employee,beginDateScope);
    }
}
