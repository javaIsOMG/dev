package com.zsy.hr.domian.po;

import java.util.Date;

public class Position {
    private Integer id;

    private String name;

    private Date createdate;

    private Boolean enabled;

    public Position(Integer id, String name, Date createdate, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.createdate = createdate;
        this.enabled = enabled;
    }

    public Position(){

    }

    public Position(String cellValue) {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}