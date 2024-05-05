package com.scm.arjun.scm20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "This is testing name");
        model.addAttribute("text", " abc testing text");
        System.out.println("On the home page >>>>>>");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("isLogin",true);
        model.addAttribute("aboutUs", "Demo");
        System.out.println("Under Services Page");
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        
        System.out.println("Under Services Page");
        return "services";
    }


  


}
