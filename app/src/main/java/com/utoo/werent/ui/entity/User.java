package com.utoo.werent.ui.entity;

import java.io.Serializable;

/**
 * Created by Lenovo on 2015/10/30.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1955160633283781400L;
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private String note;
    private Long lastlogintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }
}
