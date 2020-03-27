package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.po.Politicsstatus;
import com.zsy.hr.mapper.PoliticsstatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-27 17:19
 */
@Service
public class PoliticsstatusServiceImpl implements com.zsy.hr.service.PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;
    @Override
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
