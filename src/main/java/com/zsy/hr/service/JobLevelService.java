package com.zsy.hr.service;

import com.zsy.hr.domian.po.Joblevel;

import java.util.List;

public interface JobLevelService {
    public List<Joblevel> getAllJobLevels();
    public Integer addJobLevel(Joblevel jobLevel);
    public Integer updateJobLevelById(Joblevel jobLevel);
    public Integer deleteJobLevelById(Integer id);
    public Integer deleteJobLevelsByIds(Integer[] ids);
}
