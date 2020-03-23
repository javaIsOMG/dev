package com.zsy.hr.service;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Employee;

import java.util.Date;

/**
 * @Classname EmployeeService
 * @Description TODO
 * @Date 2020/3/23 15:36
 * @Created by Yinghao.He
 */
public interface EmployeeService {

    public Result getEmployeeInfo(Integer page, Integer size, Employee employee, Date[] beginDateScope);
}
