package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.po.Salary;
import com.zsy.hr.mapper.SalaryMapper;
import com.zsy.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-29 15:01
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
