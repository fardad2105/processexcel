package com.processexcel.controller.Admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/admin")
public class AdminController {


    @RequestMapping(value = "/adduser")
    public String addUser()
    {
        return "addUser";
    }
}
