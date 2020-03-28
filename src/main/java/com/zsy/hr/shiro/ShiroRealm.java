package com.zsy.hr.shiro;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.dto.RolesDto;
import com.zsy.hr.domian.dto.UserData;
import com.zsy.hr.domian.po.Hr;
import com.zsy.hr.domian.po.Role;
import com.zsy.hr.service.LoginService;
import com.zsy.hr.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



/**
 * @Classname LoginController
 * @Description TODO
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
 * @Date 2020/3/2116:05
 * @Created by yuan
=======
 * @Date 2020/3/21 16:05
=======
 * @Date 2020/3/2116:05
>>>>>>> 5c92661... yuan
 * @Created by yuan1
>>>>>>> 95d4e09... 111
=======
 * @Date 2020/3/2116:05
 * @Created by yuan1
>>>>>>> 86d512547ea8bfd0d34b23d3fefecda344d9ee49
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;

    @Resource
    private RedisUtil redisUtils;


    //权限管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Hr userData = loginService.GetUserName(username);

        UserData userData1 = new UserData();
        BeanUtils.copyProperties(userData, userData1);

        if (userData != null) {
            if (userData.getPassword().equals(new String(token.getPassword()))) {
                List<RolesDto> rolesDtos = loginService.GetRole(userData.getId());
                List<Role> roles = new ArrayList<Role>();

                for (RolesDto rdto : rolesDtos) {
                    roles.add(rdto.getRoles());
                }
                userData1.setRole(roles);
                Result result = new Result();
                result.ok(userData);
                redisUtils.set(username, userData1, 1000);

                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userData.getUsername(), userData.getPassword(), getName());

                return info;
            }
            throw new AuthenticationException("密码错误");
        }
        else {
             throw new AuthenticationException("不存在该用户");
        }

    }
}

