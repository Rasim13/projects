package ru.itis.site.services;

import ru.itis.site.dto.AccountDto;
import ru.itis.site.forms.SignUpForm;


public interface SignUpService {
    AccountDto signUp(SignUpForm form);
}
