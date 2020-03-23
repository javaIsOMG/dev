package com.zsy.hr.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Employee;
import com.zsy.hr.mapper.EmployeeMapper;
import com.zsy.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname EmployeeServiceImpl
 * @Description TODO
 * @Date 2020/3/23 15:38
 * @Created by Yinghao.He
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Result getEmployeeInfo(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        PageHelper.startPage(page,size);
        List<Employee> employeesList =employeeMapper.selectAll();
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employeesList);
        return Result.ok(employeesList,employeesList.size());
    }
}
