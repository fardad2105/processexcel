package com.processexcel.controller;

import com.processexcel.model.authorities;
import com.processexcel.model.users;
import com.processexcel.repo.RoleRepo;
import com.processexcel.repo.UserRepo;
import com.processexcel.utils.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class User_reg_logController {


    public static final Logger logger = LoggerFactory.getLogger(User_reg_logController.class);


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @PostMapping(value = "/register/user",produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<?> saveuser(@ModelAttribute users users)
    {
        if (users !=null)
        {
            userRepo.save(users);

            authorities authorities = new authorities();
            authorities.setUsername(users.getUsername());

            if (users.getSystemAdmin())
                authorities.setAuthority("ROLE_ADMIN");
            else if (users.getCompanyAdmin())
                authorities.setAuthority("ROLE_USER");

            authorities.setUsers(users);

            roleRepo.save(authorities);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{username}")
                    .buildAndExpand(users.getUsername()).toUri();

            return ResponseEntity.created(location).build();
        }

        else
        {
            logger.info("user not found");
            return  new ResponseEntity<>(new CustomErrorType("your request is not found"), HttpStatus.NOT_FOUND);
        }

    }
}
