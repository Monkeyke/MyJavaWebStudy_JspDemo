package com.library.pojo;

import sun.java2d.pipe.SpanClipRenderer;

import java.io.Serializable;

public class Borrow_booksBean implements Serializable {
    private Integer id;
    private  Integer card_id;
    private Integer book_id;
    private String borrow_date;
    private String end_date;
    private String return_date;
    private String illegal;
    private String manager_id;

    public Borrow_booksBean(Integer id, Integer card_id, Integer book_id, String borrow_date, String end_date, String return_date) {
        this.id = id;
        this.card_id = card_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.end_date = end_date;
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "Borrow_booksBean{" +
                "id=" + id +
                ", card_id=" + card_id +
                ", book_id=" + book_id +
                ", borrow_date='" + borrow_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", return_date='" + return_date + '\'' +
                ", illegal='" + illegal + '\'' +
                ", manager_id='" + manager_id + '\'' +
                '}';
    }

    public Borrow_booksBean(Integer id, Integer card_id, Integer book_id, String borrow_date, String end_date, String return_date, String illegal, String manager_id) {
        this.id = id;
        this.card_id = card_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.end_date = end_date;
        this.return_date = return_date;
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

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getIllegal() {
        return illegal;
    }

    public void setIllegal(String illegal) {
        this.illegal = illegal;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public Borrow_booksBean() {
    }
}
