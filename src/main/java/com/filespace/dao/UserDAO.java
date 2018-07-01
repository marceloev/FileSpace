package com.filespace.dao;

import com.filespace.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class UserDAO extends GenericDao<User, Integer> {

    public UserDAO() {
        super(User.class, Persistence.createEntityManagerFactory("FileSpace"));
    }

    public User findByLogin(String login) throws Exception, NoResultException {
        Query query = getEntityManager().createNamedQuery("User.findByLogin");
        query.setParameter("P_LOGIN", login);
        return (User) query.getSingleResult();
    }

    public int countUserByLogin(String login) {
        Query query = getEntityManager().createNamedQuery("User.countUserByLogin");
        query.setParameter("P_LOGIN", login);
        return query.getResultList().size();
    }

}
