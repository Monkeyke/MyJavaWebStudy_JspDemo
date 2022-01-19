package com.library.pojo;

import java.io.Serializable;

public class MessageBean implements Serializable {
    private Integer id;
    private  Integer card_id;
    private  String detail;
    private String public_date;

    @Override
    public String toString() {
        return "MessageBean{" +
                "id=" + id +
                ", card_id=" + card_id +
                ", detail='" + detail + '\'' +
                ", public_date='" + public_date + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPublic_date() {
        return public_date;
    }

    public void setPublic_date(String public_date) {
        this.public_date = public_date;
    }

    public MessageBean() {
    }

    public MessageBean(Integer id, Integer card_id, String detail, String public_date) {
        this.id = id;
        this.card_id = card_id;
        this.detail = detail;
        this.public_date = public_date;
    }
}
