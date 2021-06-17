package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.forms.SignUpForm;
import ru.itis.site.services.AccountService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AccountService accountService;

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public ModelAndView getUsersPage() {
//        List<AccountDto> accounts = accountService.getAll();
//        ModelAndView modelAndView = new ModelAndView("users");
//        modelAndView.addObject("accounts", accounts);
//        return modelAndView;
//    }


        @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        List<AccountDto> accounts = accountService.getAll();
        model.addAttribute("accounts", accounts);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addNewUsers(SignUpForm form) {
            accountService.addUser(form);
            return "redirect:/users";
    }
}
