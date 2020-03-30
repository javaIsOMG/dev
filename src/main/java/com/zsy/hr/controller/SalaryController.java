package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Salary;
import com.zsy.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-29 14:49
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();//xiugai
    }

    @PostMapping("/")
    public Result addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return Result.ok("","添加成功!",200);
        }
        return Result.ok("","添加失败!",200);
    }

    @DeleteMapping("/{id}")
    public Result deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return Result.ok("","删除成功！",200);
        }
        return Result.ok("","删除失败！",200);
    }

    @PutMapping("/")
    public Result updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return Result.ok("","更新成功!",200);
        }
        return Result.ok("","更新失败!",200);
    }
}
