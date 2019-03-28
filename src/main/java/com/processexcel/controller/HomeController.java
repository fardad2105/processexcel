package com.processexcel.controller;

import com.processexcel.model.users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ModelAndView("home");
    }

    @RequestMapping("/addexcel")
    public ModelAndView firstPage() {
        return new ModelAndView("addExcel");
    }







}
