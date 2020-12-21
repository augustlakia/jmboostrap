package com.springboot.crud.jm_crud.DAO;


import com.springboot.crud.jm_crud.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDAO {

    public void add(User user);
    public List<User> getUsersList();
    public User findById(int id);
    public void Update(User user);
    public void Delete(int id);
    public UserDetails loadUserByUsername(String s);
    public boolean isCreated();
}
