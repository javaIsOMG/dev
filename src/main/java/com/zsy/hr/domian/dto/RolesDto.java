package com.zsy.hr.domian.dto;

import com.zsy.hr.domian.po.HrRole;
import com.zsy.hr.domian.po.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: Hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-23 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesDto extends HrRole {

    private Role roles;

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }


}
