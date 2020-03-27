package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.*;
import com.zsy.hr.service.*;
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

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Result getEmployeeInfo(@RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "10")Integer size,
                                  @Valid Employee employee,
                                   Date[] beginDateScope){
        return employeeService.getEmployeeInfo(page,size,employee,beginDateScope);
    }
    @PostMapping("/")
    public Result addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return Result.ok();
        }
        return Result.fail("添加失败!");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployeed(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public Result upDataEmp(@RequestBody Employee employee){
        return employeeService.upDataEmp(employee);
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
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
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
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, NationService.getAllNations(), politicsstatusService.getAllPoliticsstatus(), departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

}
