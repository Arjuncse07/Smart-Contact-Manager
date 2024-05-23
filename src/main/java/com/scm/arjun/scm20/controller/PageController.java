package com.scm.arjun.scm20.controller;

import com.scm.arjun.scm20.entities.User;
import com.scm.arjun.scm20.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.arjun.scm20.forms.UserForm;

@Controller
public class PageController {

    @Autowired
    private UserServices userServices;

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


    @GetMapping("/contact")
    public String contact(){
        System.out.println("Contact Html Page");
        return "contact";
    }

    @GetMapping("/login")
    public String login()
    {
        System.out.println("Login Html");
        return "login";
    }


    @GetMapping("/register")
    public String register(Model model){

       try{
        UserForm userForm = new UserForm();
        userForm.setName("arjun");
        userForm.setEmail("aj629280@gmail.com");
        userForm.setPhoneNumber("8954967747");
        userForm.setAbout("Write something about yourlself");
        model.addAttribute("userData", userForm);
       System.out.println("Register Controller");
       }catch(Exception e){
        e.printStackTrace();
       }
        
        return "register";
    }

    // Process of Register

    @PostMapping("/do-register")
    public String registerProcess(@ModelAttribute UserForm userForm){

       User user = User.builder()
               .name(userForm.getName())
               .email(userForm.getEmail())
               .phoneNumber(userForm.getPhoneNumber())
               .about(userForm.getAbout())
               .build();

        userServices.saveUser(user);



        return "redirect:/register";
    }
  


}
