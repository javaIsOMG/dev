package com.zsy.hr.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-25 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

    private Boolean keepalive;

    private Boolean requireauth;
}
