package com.library.pojo;

import java.io.Serializable;

public class RulesBean implements Serializable {
    private Integer id;
    private Integer borrow_num;
    private Integer limit_day;
    private String borrow_library;
    private float overtime_fee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBorrow_num() {
        return borrow_num;
    }

    public void setBorrow_num(Integer borrow_num) {
        this.borrow_num = borrow_num;
    }

    public Integer getLimit_day() {
        return limit_day;
    }

    public void setLimit_day(Integer limit_day) {
        this.limit_day = limit_day;
    }

    public String getBorrow_library() {
        return borrow_library;
    }

    public void setBorrow_library(String borrow_library) {
        this.borrow_library = borrow_library;
    }

    public float getOvertime_fee() {
        return overtime_fee;
    }

    public void setOvertime_fee(float overtime_fee) {
        this.overtime_fee = overtime_fee;
    }

    public RulesBean() {
    }

    public RulesBean(Integer id, Integer borrow_num, Integer limit_day, String borrow_library, float overtime_fee) {
        this.id = id;
        this.borrow_num = borrow_num;
        this.limit_day = limit_day;
        this.borrow_library = borrow_library;
        this.overtime_fee = overtime_fee;
    }
}
