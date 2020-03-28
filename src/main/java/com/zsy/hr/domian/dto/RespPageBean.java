package com.zsy.hr.domian.dto;

import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-27 21:57
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
