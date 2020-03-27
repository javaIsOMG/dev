package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.po.Department;
import com.zsy.hr.mapper.DepartmentMapper;
import com.zsy.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-27 16:49
 */
@Service
public class DepamentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }
    @Override
    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }
    @Override
    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }
    @Override
    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }
}
