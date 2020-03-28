package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.dto.RolesDto;
import com.zsy.hr.domian.dto.UserData;
import com.zsy.hr.domian.po.Hr;
import com.zsy.hr.mapper.HrMapper;
import com.zsy.hr.mapper.HrRoleMapper;
import com.zsy.hr.mapper.RoleMapper;
import com.zsy.hr.service.LoginService;
import com.zsy.hr.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;
    @Autowired
    private RedisUtil redisUtils;
    private Map canche;

    @Override
    public Hr GetUserName(String username) {
        if(hrMapper.getPassword(username)!=null) {
            Hr hr=hrMapper.findUsername(username);
            return hr;
        }
        return null;
    }

    @Override
    public List<RolesDto> GetRole(Integer hrid) {
        List<RolesDto> rolesDto= hrRoleMapper.GetUserRole(hrid);
        return rolesDto;
    }

    @Override
    public UserData GetUserData(String username) {
        UserData userData= (UserData) redisUtils.get(username);
        return userData;
    }

    @Override
    public void canche() {
        this.canche=new HashMap();
    }

    @Override
    public void mapcanche(String username) {
    }


}
