package com.zsy.hr.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Employee;
import com.zsy.hr.mapper.EmployeeMapper;
import com.zsy.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    @Override
    public Result getEmployeeInfo(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        PageHelper.startPage(page,size);
        List<Employee> employeesList =employeeMapper.selectAll();
        return Result.ok(employeesList,employeesList.size());
    }
    /**
     * @Description 当新增员工时需要加入异步发送邮件
     * @param
     * @Return
     * @Author YingHao He
     * @Since 2020/3/25
     */
    @Override
    public int addEmp(Employee employee) {
        Date beginContract = employee.getBegincontract();
        Date endContract = employee.getEndcontract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result=employeeMapper.insertSelective(employee);
        if (result==1){
            return result;
        }
        return result;
    }

    @Override
    public Result deleteEmployeed(Integer id) {
        int i = employeeMapper.deleteByPrimaryKey(id);
        if (i==1){
            return Result.ok();
        }
        return Result.fail("删除失败");
    }

    @Override
    public Result upDataEmp(Employee employee) {
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        if (i==1){
            return Result.ok();
        }
        return Result.fail("跟新失败");
    }
}
