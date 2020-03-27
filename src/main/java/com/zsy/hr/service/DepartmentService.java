package com.zsy.hr.service;

import com.zsy.hr.domian.po.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartments();
    public void addDep(Department dep);
    public void deleteDepById(Department dep);
    public List<Department> getAllDepartmentsWithOutChildren();
}
