package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by linziyu on 2018/5/14.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByRolename(String name);
}
