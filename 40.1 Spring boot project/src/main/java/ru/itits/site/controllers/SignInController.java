package ru.itits.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itits.site.forms.SignUpForm;

import javax.validation.Valid;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignInPage() {
        CartController.cart.clear();
        return "signIn";
    }

    @PostMapping("/signIn")
    public String chekUser(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        return "redirect:/signIn";
    }
}
