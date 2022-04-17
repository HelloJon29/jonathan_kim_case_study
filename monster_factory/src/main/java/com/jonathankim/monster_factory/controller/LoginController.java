package com.jonathankim.monster_factory.controller;

import com.jonathankim.monster_factory.security.User;
import com.jonathankim.monster_factory.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController {
    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/testPage")
    public String test(Principal principal, Model model) {
        try {
            User user = userRepository.findByEmail(principal.getName());
            model.addAttribute("email", principal.getName());
            model.addAttribute("firstname", user.getFirstName());
        } catch(NullPointerException e) {
            System.out.println("No role");
        }
        return "testPrincipal";
    }

}
