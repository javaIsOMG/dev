package com.zsy.hr.mapper;

import com.zsy.hr.domian.dto.RolesDto;
import com.zsy.hr.domian.po.HrRole;
import com.zsy.hr.domian.po.Role;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    List<RolesDto> GetUserRole(@Param(value = "hrid") Integer hrid);
}