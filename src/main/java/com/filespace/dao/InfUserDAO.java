package com.filespace.dao;

import com.filespace.entity.InfUser;

import javax.persistence.Persistence;

public class InfUserDAO extends GenericDao<InfUser, Integer> {

    public InfUserDAO() {
        super(InfUser.class, Persistence.createEntityManagerFactory("FileSpace"));
    }
}
