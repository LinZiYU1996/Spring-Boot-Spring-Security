package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by linziyu on 2018/5/13
 *
 * 角色实体类
 *
 */

@Entity
@Table(name = "role1")
public class Role {

    @Id
    @GeneratedValue
    private long id;

    private String rolename;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
