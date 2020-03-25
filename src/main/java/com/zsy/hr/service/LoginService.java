package com.zsy.hr.service;


import com.zsy.hr.domian.dto.RolesDto;
import com.zsy.hr.domian.dto.UserData;
import com.zsy.hr.domian.po.Hr;

import java.util.List;


/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
<<<<<<< HEAD
 * @Created by yuan
 */
public interface LoginService {
    public Hr GetUserName(String username);

    public List<RolesDto> GetRole(Integer hrid);

    public UserData GetUserData(String username);

    void canche();

    void mapcanche(String username);
}


