package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.po.Hr;
import com.zsy.hr.domian.vo.HrVo;
import com.zsy.hr.mapper.HrMapper;
import com.zsy.hr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
 * @Created by yuan1
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    HrMapper hrMapper;

    @Override
    public Hr GetUserName(String username) {
        if(hrMapper.getPassword(username)!=null) {
            Hr hr=hrMapper.findUsername(username);
            return hr;
        }
        return null;
    }
}
