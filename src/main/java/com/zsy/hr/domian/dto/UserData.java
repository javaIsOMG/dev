package com.zsy.hr.domian.dto;

import com.zsy.hr.domian.po.Hr;
import com.zsy.hr.domian.po.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: Hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-23 15:36
 */
public class UserData extends Hr  {

    private List<Role> role;

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
