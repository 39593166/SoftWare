package com.utoo.werent.ui.entity;

import java.io.Serializable;

/**
 * Created by Lenovo on 2015/10/30.
 */
public class Group implements Serializable {
    private static final long serialVersionUID = -4948958967040769780L;

    private Integer id;
    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
