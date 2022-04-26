package com.jonathankim.monster_factory.login_home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showIndex() {
        return "index";
    }
}
