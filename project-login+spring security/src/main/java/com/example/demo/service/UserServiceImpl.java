package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by linziyu on 2018/5/13.
 * 用户Service实现类
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> PageByUser(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page,size, Sort.Direction.ASC, "id");
        return userRepository.findAll(pageable);
    }
}
