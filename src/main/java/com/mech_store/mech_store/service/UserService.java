package com.mech_store.mech_store.service;

import com.mech_store.mech_store.collection.User;

import java.util.List;

public interface UserService {
    List<User> getallUsers();

    String addUser(User user);

}
