package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.forms.SignUpForm;
import ru.itis.site.services.AccountService;

import java.awt.*;
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

    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    // аннотация указывает на то, что возвращается конкретный объект
    @ResponseBody
    public List<AccountDto> getUsers() {
            return accountService.getAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addNewUsers(SignUpForm form) {
            accountService.addUser(form);
            return "redirect:/users";
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    // аннотация указывает на то, что возвращается конкретный объект
    @ResponseBody
    public AccountDto addNewUserFromJson (@RequestBody SignUpForm form) {
        return accountService.addUser(form);
    }
}
