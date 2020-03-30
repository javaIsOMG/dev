package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.RespPageBean;
import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.*;
import com.zsy.hr.service.*;
import com.zsy.hr.util.POIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmployeeByPage(page, size, employee,beginDateScope);
    }

    @PostMapping("/")
    public Result addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return Result.ok("","添加成功!",200);
        }
        return Result.ok("","添加失败!",200);
    }

    @DeleteMapping("/{id}")
    public Result deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return Result.ok("","删除成功!",200);
        }
        return Result.ok("","删除失败!",200);
    }

    @PutMapping("/")
    public Result updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return Result.ok("","更新成功!",200);
        }
        return Result.ok("更新失败!",200);
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    public List<Joblevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkID")
    public Result maxWorkID() {
        return Result.ok(String.format("%08d", employeeService.maxWorkID() + 1) );
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(null, null, new Employee(),null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public Result importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatus(), departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()) {
            return Result.ok("","上传成功",200);
        }
        return Result.ok("","上传失败",200);
    }

}
