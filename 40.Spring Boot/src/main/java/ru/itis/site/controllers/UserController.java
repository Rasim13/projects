package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.services.AccountsService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AccountsService accountService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<AccountDto> accounts = accountService.getAll();
        model.addAttribute("accounts", accounts);
        return "users";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users/{user-id}/ban")
    public String banUser(@PathVariable("user-id") Long userId) {
        accountService.ban(userId);
        return "redirect:/users";
    }
}
