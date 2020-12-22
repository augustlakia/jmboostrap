package com.springboot.crud.jm_crud.services;


import com.springboot.crud.jm_crud.DAO.UserDAO;
import com.springboot.crud.jm_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UserServImp implements UserServ, UserDetailsService
{

    private final UserDAO userDAO;

    public UserServImp(EntityManagerFactory em, UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public void add(User user) {
        userDAO.add(user);
    }

    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    public User findById(int id) {
        return userDAO.findById(id);
    }

    public void Update(User user) {
        userDAO.Update(user);
    }

    public void Delete(int id ) {
        userDAO.Delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.loadUserByUsername(s);
    }

    public boolean isCreated() {
        return userDAO.isCreated();
    }
}
