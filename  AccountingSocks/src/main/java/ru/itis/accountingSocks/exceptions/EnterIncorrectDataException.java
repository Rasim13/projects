package ru.itis.accountingSocks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.accountingSocks.forms.SocksForm;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnterIncorrectDataException extends RuntimeException {

    public EnterIncorrectDataException(SocksForm socksFrom) {
        super("Entered incorrect data: " + "quantity = " + socksFrom.getQuantity() + " cotton part = " + socksFrom.getCottonPart());
    }
}
