package com.springboot.crud.jm_crud.DAO;


import com.springboot.crud.jm_crud.model.Role;
import com.springboot.crud.jm_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Repository
public class RoleDAOImp implements RoleDAO {

    @Autowired
    EntityManager em;



    public Role findByName(String s) {
        return em.createQuery("select us from Role us where us.name=:name", Role.class).setParameter("name", s).getSingleResult();
    }

    @Transactional
    public void add(Role role) {
        em.persist(role);
    }

}
