package com.springboot.crud.jm_crud.services;

import com.springboot.crud.jm_crud.DAO.RoleDAO;
import com.springboot.crud.jm_crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServImp implements RoleServ {

    @Autowired
    private RoleDAO roleDAO;

    public Role findByName(String s) {
        return roleDAO.findByName(s);
    }

}
