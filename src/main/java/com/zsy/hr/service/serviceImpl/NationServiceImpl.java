package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.po.Nation;
import com.zsy.hr.mapper.NationMapper;
import com.zsy.hr.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-27 17:14
 */
@Service
public class NationServiceImpl implements NationService {
    @Autowired
    NationMapper nationMapper;
    @Override
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
