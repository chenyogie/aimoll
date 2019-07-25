package com.yogie.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: aimoll
 * @Date: 2019/7/20 23:29
 * @Author: Chenyogie
 * @Description:
 */
public class OnlineUser {

    private Serializable id;
    private String host;
    private String username;
    private Date lastAccessTime;

    public OnlineUser(){}

    public OnlineUser(Serializable id, String host, String username, Date lastAccessTime) {
        this.id = id;
        this.host = host;
        this.username = username;
        this.lastAccessTime = lastAccessTime;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}
