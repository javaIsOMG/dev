package com.zsy.hr.service;

import com.zsy.hr.domian.dto.RespPageBean;
import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Employee;

import java.util.Date;
import java.util.List;

/**
 * @Classname EmployeeService
 * @Description TODO
 * @Date 2020/3/23 15:36
 * @Created by Yinghao.He
 */
public interface EmployeeService {

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope);

    public Integer addEmp(Employee employee);

    Integer addEmps(List<Employee> list);

    Integer maxWorkID();

    public Integer deleteEmpByEid(Integer id);

    public Integer updateEmp(Employee employee);

    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size);

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid);

    public Employee getEmployeeById(Integer empId) ;
}
