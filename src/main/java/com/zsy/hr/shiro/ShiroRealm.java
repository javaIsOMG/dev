package com.zsy.hr.shiro;

import com.zsy.hr.domian.vo.HrVo;
import com.zsy.hr.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/3/21 16:05
 * @Created by yuan
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;

    //权限管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String username=token.getUsername();
        HrVo hrvo=loginService.GetUserNamePassword(username);
        if(hrvo!=null){
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo( hrvo.getUserName(),hrvo.getPassword() ,getName());
            return info;
        }else{
            System.out.println("======不存在该用户=========>");
            throw new UnknownAccountException("不存在该用户");
        }
    }
}
