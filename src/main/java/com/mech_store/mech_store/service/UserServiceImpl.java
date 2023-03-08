package com.mech_store.mech_store.service;

import com.mech_store.mech_store.collection.User;
import com.mech_store.mech_store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getallUsers() {
        return userRepository.findAll();
    }

    @Override
    public String addUser(User user) {
        return userRepository.save(user).getId();
    }

}
