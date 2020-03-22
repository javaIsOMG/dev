package com.zsy.hr.shiro;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Hr;
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
 * @Date 2020/3/2116:05
 * @Created by yuan1
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
        Hr hrvo=loginService.GetUserName(username);

        if(hrvo!=null){
            if(hrvo.getPassword().equals(new String (token.getPassword() ) )){
                Result result=new Result();
                SimpleAuthenticationInfo info=new SimpleAuthenticationInfo( hrvo.getUsername(),hrvo.getPassword() ,getName());
                return info;
            }

            throw new AuthenticationException("密码错误");

        }else{

            throw new AuthenticationException("不存在该用户");
        }
    }
}
