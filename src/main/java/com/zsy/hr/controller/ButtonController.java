package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/menu",method = RequestMethod.POST)
    public Result getButton(@RequestBody List<Integer> hid){
        return menuService.getButton(hid);
    }
}
