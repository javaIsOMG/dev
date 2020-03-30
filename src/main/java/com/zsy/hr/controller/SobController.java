package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.RespPageBean;
import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Salary;
import com.zsy.hr.service.EmployeeService;
import com.zsy.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-29 14:50
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SobController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("/salaries")//xiugai
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PutMapping("/")
    public Result updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result == 1 || result == 2) {
            return Result.ok("","更新成功",200);
        }
        return Result.ok("","更新失败",200);
    }
}
