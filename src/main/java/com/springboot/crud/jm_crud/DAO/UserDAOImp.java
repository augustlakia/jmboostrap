package com.springboot.crud.jm_crud.DAO;

import com.springboot.crud.jm_crud.model.Role;
import com.springboot.crud.jm_crud.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class UserDAOImp implements UserDAO {

    private DataSource datasource;

    private final EntityManager em;



    public UserDAOImp(EntityManagerFactory em, DataSource datasource) {
        this.em = em.createEntityManager();
        this.datasource = datasource;
    }

    @Transactional
    public void add(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public List<User> getUsersList() {
        return em.createQuery("select us from User us",User.class).getResultList();
    }

    public User findById(int id) {
        return (User) em.createQuery("select u from User u where u.id =:id")
                .setParameter("id", Long.parseLong(String.valueOf(id)))
                .getSingleResult();
    }

    public void Update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void Delete(int id) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM User us  where us.id =:id").setParameter("id", Long.parseLong(String.valueOf(id))).executeUpdate();
        em.getTransaction().commit();
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return em.createQuery("select us from User us where us.name=:name", User.class).setParameter("name", s).getSingleResult();
    }

    @Transactional
    public boolean isCreated() {
        boolean isExist = false;
        try {
            User us = findById(1);
            if (!us.getName().equals("ADMIN") || !us.getName().equals("USER")) {
                isExist = true;
            }
        } catch (Exception throwables) {
            System.out.println("ошибка");
        }
        return isExist;
    }
}
