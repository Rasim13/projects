package ru.itis.site.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.site.security.details.AccountUserDetails;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal AccountUserDetails userDetails) {
        model.addAttribute("email", userDetails.getUsername());
        return "profile";
    }
}
