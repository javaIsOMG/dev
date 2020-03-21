package com.zsy.hr.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname HrDto
 * @Description TODO
 * @Date 2020/3/21 16:07
 * @Created by Yinghao.He
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrVo implements Serializable {
    private static final long serialVersionUID = -1749756244328275928L;
    private String userName;
    private String password;
}
