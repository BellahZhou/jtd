package com.jtd.entity;

import java.util.Date;

public class UserAttends extends IDE{
    private Long id;

    private Long userId;

    private String userName;

    private Long attends;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getAttends() {
        return attends;
    }

    public void setAttends(Long attends) {
        this.attends = attends;
    }

}