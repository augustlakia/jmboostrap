package com.springboot.crud.jm_crud.DAO;


import com.springboot.crud.jm_crud.model.Role;
import com.springboot.crud.jm_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class RoleDAOImp implements RoleDAO {

    final EntityManager em;


    public RoleDAOImp(EntityManager em) {
        this.em = em;
    }


    public Role findByName(String s) {
        return em.createQuery("select us from Role us where us.name=:name", Role.class).setParameter("name", s).getSingleResult();
    }
}
