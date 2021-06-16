package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.services.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersController implements Controller {

    @Autowired
    private AccountService accountService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<AccountDto> accounts = accountService.getAll();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("accounts", accounts);
        return modelAndView;
    }
}
