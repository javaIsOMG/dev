package com.zsy.hr.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-25 16:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTree {

    private Integer id;

    private String path;

    private String component;

    private String name;

    private String iconcls;

    private List<MenuTree> children;

    private Meta meta;

    public void setChildren() {
        this.children = new ArrayList<MenuTree>();
    }

    public void setMeta(Boolean keepalive,Boolean requireauth){
        meta=new Meta();
        if(keepalive==null){
            keepalive=false;
        }
        if (requireauth==null){
            requireauth=false;
        }
        this.meta.setKeepalive(keepalive);
        this.meta.setRequireauth(requireauth);
    }
}
