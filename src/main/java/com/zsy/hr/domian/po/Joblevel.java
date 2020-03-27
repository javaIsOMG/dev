package com.zsy.hr.domian.po;

import java.util.Date;

public class Joblevel {
    private Integer id;

    private String name;

    private String titlelevel;

    private Date createdate;

    private Boolean enabled;

    public Joblevel(Integer id, String name, String titlelevel, Date createdate, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.titlelevel = titlelevel;
        this.createdate = createdate;
        this.enabled = enabled;
    }

    public Joblevel() {
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

    public String getTitlelevel() {
        return titlelevel;
    }

    public void setTitlelevel(String titlelevel) {
        this.titlelevel = titlelevel == null ? null : titlelevel.trim();
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