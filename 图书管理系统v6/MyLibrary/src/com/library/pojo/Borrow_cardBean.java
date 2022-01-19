package com.library.pojo;

import java.io.Serializable;

public class Borrow_cardBean implements Serializable {
    private Integer id ;
    private String password;
    private String reader;
    private Integer rule_id;
    private Integer status;

    public Borrow_cardBean() {
    }

    @Override
    public String toString() {
        return "Borrow_cardBean{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", reader='" + reader + '\'' +
                ", rule_id=" + rule_id +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Borrow_cardBean(Integer id, String password, String reader, Integer rule_id, Integer status) {
        this.id = id;
        this.password = password;
        this.reader = reader;
        this.rule_id = rule_id;
        this.status = status;
    }
}
