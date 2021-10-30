package ru.itis.accountingSocks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.accountingSocks.models.Socks;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundNumberException extends RuntimeException {

    public NotFoundNumberException (Socks socks) {
        super("Not found number: = " + socks.getQuantity());
    }
}
