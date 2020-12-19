package com.springboot.crud.jm_crud.services;

import com.springboot.crud.jm_crud.model.User;

import java.util.List;

public interface UserServ {

    public void add(User user);

    public List<User> getUsersList();

    public void Update(User user);

    public void Delete(int id);

}
