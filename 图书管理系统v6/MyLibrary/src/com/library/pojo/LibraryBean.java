package com.library.pojo;

import java.io.Serializable;

public class LibraryBean implements Serializable {
    private Integer id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "LibraryBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public LibraryBean() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LibraryBean(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
