package com.zsy.hr.domian.po;

public class Politicsstatus {
    private Integer id;

    private String name;

    public Politicsstatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Politicsstatus(){

    }

    public Politicsstatus(String cellValue) {
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
}