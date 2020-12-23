package com.springboot.crud.jm_crud.DAO;

import com.springboot.crud.jm_crud.model.Role;

public interface RoleDAO {
    public Role findByName(String s);
    public void add(Role role);
}
