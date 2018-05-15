package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by linziyu on 2018/5/13.

 * 用户实体类，通过实现UserDetails接口实现认证及授权
 */
@Entity
@Table(name = "user1") //设置对应表名字
public class User implements UserDetails{

    //主键及自动增长
    @Id
    @GeneratedValue
    private  long id;
    private String name;
    private String password;

    //多对多映射，用户角色
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    //获取当前用户实例的password
    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    //根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = this.getRoles();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return authorities;
    }
    //获取当前用户实例的name
    @Override
    public String getUsername() {
        return this.name;
    }


    //帐号是否不过期，false则验证不通过
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //帐号是否不锁定，false则验证不通过
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证是否不过期，false则验证不通过
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //该帐号是否启用，false则验证不通过
    @Override
    public boolean isEnabled() {
        return true;
    }
}
