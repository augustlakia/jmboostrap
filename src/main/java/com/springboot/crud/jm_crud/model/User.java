package com.springboot.crud.jm_crud.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String age;


    private String email;

    private String password;


    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String lastName, String age, String email, String password, Set<Role> roles) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getRoles1() {
        StringBuilder rol = new StringBuilder("");
        for (Role i: roles ) {
            if (i.getName().contains("ADMIN"))  {
                rol.append("ADMIN USER");
            }
            if (i.getName().contains("USER"))  {
                rol.append("USER");
            }
        }
        return rol.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getRolesString() {
        StringBuilder rolesToString = new StringBuilder();
        for (Role i: getRoles()) {
          rolesToString.append(i.getName());
        }
        return rolesToString.toString();
    }
    public String getRolesString2() {
        if (getRolesString().contains("USER") & getRolesString().contains("ADMIN")) {
            return "ADMIN USER";
        }

        if (getRolesString().contains("USER")) {
            return "USER";
        }
        if (getRolesString().contains("ADMIN")) {
            return "ADMIN";
        }
        return "NOT FIND";
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
