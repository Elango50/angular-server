package com.user.details.user.dao;


import com.user.details.user.model.UserDetails;

import java.util.List;

public interface UserDetailsDAO {

    List<UserDetails> getAllUserDetails();

    UserDetails getUserById(int userId);

    void addUser(UserDetails user);

    void updateUser(UserDetails user);

    void deleteUser(int userId);

    public boolean checkUser(String name);


    }