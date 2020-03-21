package com.zsy.hr.service;

import com.zsy.hr.domian.vo.HrVo;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
 * @Created by yuan
 */
public interface LoginService {
    public HrVo GetUserNamePassword(String userName);
}
