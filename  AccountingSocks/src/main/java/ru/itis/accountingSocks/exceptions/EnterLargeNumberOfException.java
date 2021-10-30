package ru.itis.accountingSocks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.accountingSocks.forms.SocksForm;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnterLargeNumberOfException extends RuntimeException {

    public EnterLargeNumberOfException(SocksForm socksForm) {
        super("Entered large of number: " + "quantity = " + socksForm.getQuantity());
    }
}
