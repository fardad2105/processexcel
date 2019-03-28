package com.processexcel.model;


import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private String name;
    private Boolean isCompanyAdmin;
    private Boolean isSystemAdmin;

    @OneToMany
    private List<authorities> authorities = new ArrayList<>();

    public users() {
    }

    public users(String username, String password, Boolean enabled, String name, Boolean isCompanyAdmin, Boolean isSystemAdmin) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.isCompanyAdmin = isCompanyAdmin;
        this.isSystemAdmin = isSystemAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompanyAdmin() {
        return isCompanyAdmin;
    }

    public void setCompanyAdmin(Boolean companyAdmin) {
        isCompanyAdmin = companyAdmin;
    }

    public Boolean getSystemAdmin() {
        return isSystemAdmin;
    }

    public void setSystemAdmin(Boolean systemAdmin) {
        isSystemAdmin = systemAdmin;
    }


    public List<com.processexcel.model.authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<com.processexcel.model.authorities> authorities) {
        this.authorities = authorities;
    }
}
