package com.zsy.hr.service;

import com.zsy.hr.domian.dto.Result;

import java.util.List;

/**
 * @Classname MenuService
 * @Description TODO
 * @Date 2020/3/24 15:53
 * @Created by Yinghao.He
 */
public interface MenuService {

    Result getButton(List<Integer> hid);
}
