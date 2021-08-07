package ru.itis.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class SignInController {

    @PermitAll
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn";
    }

}
