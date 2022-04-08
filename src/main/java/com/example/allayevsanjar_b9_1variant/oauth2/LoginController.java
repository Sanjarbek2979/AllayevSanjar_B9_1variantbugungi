package com.example.allayevsanjar_b9_1variant.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sanjarbek Allayev, пт 10:25. 08.04.2022
 */
@Controller
@RequestMapping("/oauth2/google")
public class LoginController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/")
    public String page(){
        return "page";
    }
}
