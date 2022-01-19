package com.library.pojo;

import sun.java2d.pipe.SpanClipRenderer;

import java.io.Serializable;

public class BookBean extends Object implements Serializable {
    private Integer id;
    private String name;
    private String author;
    private Integer library_id;
    private Integer sort_id;
    private String position;
    private Integer status;
    private String description;

    public BookBean() {
    }

    public BookBean(Integer id, String name, String author, Integer library_id, Integer sort_id, String position, Integer status, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.library_id = library_id;
        this.sort_id = sort_id;
        this.position = position;
        this.status = status;
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", library_id=" + library_id +
                ", sort_id=" + sort_id +
                ", position='" + position + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
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
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(Integer library_id) {
        this.library_id = library_id;
    }

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
