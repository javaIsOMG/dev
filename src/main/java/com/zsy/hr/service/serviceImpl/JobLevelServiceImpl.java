package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.po.Joblevel;
import com.zsy.hr.mapper.JoblevelMapper;
import com.zsy.hr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-27 17:00
 */
@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    JoblevelMapper jobLevelMapper;
    @Override
    public List<Joblevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }
    @Override
    public Integer addJobLevel(Joblevel jobLevel) {
        jobLevel.setCreatedate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }
    @Override
    public Integer updateJobLevelById(Joblevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }
    @Override
    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Integer deleteJobLevelsByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelsByIds(ids);
    }
}
