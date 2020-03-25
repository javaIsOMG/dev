package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * @Classname ButtonController
 * @Description TODO
 * @Date 2020/3/24 15:50
 * @Created by Yinghao.He
 */
@RestController
@RequestMapping("/system/config")
public class ButtonController {
    @Autowired
    private MenuService menuService;
    @RequestMapping(value = "/menu",method = RequestMethod.GET)
    public Result getButton( HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String username = cookie.getValue();
                return menuService.getButton(username);
            }
        }
        return null;

    }
}
