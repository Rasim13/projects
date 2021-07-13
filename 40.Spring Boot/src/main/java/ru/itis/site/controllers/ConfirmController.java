package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.site.services.ConfirmService;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/users/confirm/{confirm-id}")
    public String confirmUser(@PathVariable("confirm-id") String confirmId) {
        if(confirmService.confirm(confirmId)) {
            return "success_confirm";
        } else {
            return "fail_confirm";
        }

    }
}
