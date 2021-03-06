package com.zsy.hr.domian.po;

public class Nation {
    private Integer id;

    private String name;

    public Nation(Integer id,String name) {
        this.name = name;
        this.id=id;
    }

    public Nation(String name) {
        this.name = name;
    }

    public Nation() {
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
}