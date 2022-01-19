package com.library.pojo;

import java.io.Serializable;

public class AnnouncementBean implements Serializable {
    private Integer id;
    private String title;
    private String detail;
    private String publish_date;

    public AnnouncementBean() {
    }

    public AnnouncementBean(Integer id, String title, String detail, String publish_date) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.publish_date = publish_date;
    }

    @Override
    public String toString() {
        return "AnnouncementBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", publish_date='" + publish_date + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }
}
