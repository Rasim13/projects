package ru.itits.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itits.site.forms.SignUpForm;
import ru.itits.site.service.SignUpService;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpUser(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //кладем эту форму с ошибками обратно в страницу
            model.addAttribute("signUpForm", form);
            // возращаем страницу
            return "signUp";
        }
        // если все ок
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
