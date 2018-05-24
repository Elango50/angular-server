package com.user.details.user.service.dao;

import com.user.details.user.dao.UserDetailsDAO;
import com.user.details.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailsServiceImpl implements  UserDetailsService {

    @Autowired
    private UserDetailsDAO userDetailsDAO;


    @Override
    public List<UserDetails> getAllUserDetails() {
        return null;
    }

    @Override
    public UserDetails getUserById(int userId) {
        return null;
    }

    @Override
    public boolean addUser(UserDetails userDetails) {

        userDetailsDAO.addUser(userDetails);
        return false;
    }

    @Override
    public void updateUser(UserDetails userDetails) {

    }

    @Override
    public void deleteUser(int userId) {

    }
}