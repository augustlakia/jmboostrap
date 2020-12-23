package com.springboot.crud.jm_crud.services;

import com.springboot.crud.jm_crud.model.Role;

public interface RoleServ {

    public Role findByName(String s);
    public void add(Role role);
}
