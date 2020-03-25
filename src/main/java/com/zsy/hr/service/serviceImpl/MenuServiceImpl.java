package com.zsy.hr.service.serviceImpl;

import com.zsy.hr.domian.dto.Result;
import com.zsy.hr.domian.po.Menu;
import com.zsy.hr.mapper.MenuMapper;
import com.zsy.hr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname MenuServiceImpl
 * @Description TODO
 * @Date 2020/3/24 15:53
 * @Created by Yinghao.He
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Result getButton(List<Integer> hid) {
        List<Menu> menuList  =menuMapper.getMeuButton(hid);
        return Result.ok(menuList);
    }
}
