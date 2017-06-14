package com.json;

import java.util.Date;

/**
 * Created by admin on 2017/4/27.
 */

public class User {
    private Integer id;

    private String name;

    private Date date;

    public User() {
    }

    public User(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
