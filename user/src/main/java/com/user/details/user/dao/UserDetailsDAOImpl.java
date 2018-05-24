package com.user.details.user.dao;

import com.user.details.user.model.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserDetails> getAllUserDetails() {
        return null;
    }

    @Override
    public UserDetails getUserById(int userId) {
        return null;
    }

    @Override
    public void addUser(UserDetails user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public boolean checkUser(String name) {

        String hql = "FROM UserDetails as atcl WHERE atcl.name = ?";
        int count = entityManager.createQuery(hql).setParameter(1, name)
                .getResultList().size();
        return count > 0 ? true : false;
    }
}