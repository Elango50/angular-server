package com.user.details.user.service.dao;

import com.user.details.user.model.UserDetails;

import java.util.List;

public interface UserDetailsService {

    List<UserDetails> getAllUserDetails();

    UserDetails getUserById(int userId);

    boolean addUser(UserDetails userDetails);

    void updateUser(UserDetails userDetails);

    void deleteUser(int userId);



}