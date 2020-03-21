package com.zsy.hr.mapper;

import com.zsy.hr.domian.po.Hr;
import org.apache.ibatis.annotations.Mapper;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    String getPassword(String username);
}