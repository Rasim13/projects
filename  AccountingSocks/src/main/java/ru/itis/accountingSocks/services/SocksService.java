package ru.itis.accountingSocks.services;

import ru.itis.accountingSocks.dto.SocksDto;
import ru.itis.accountingSocks.forms.SocksForm;

public interface SocksService {
    SocksDto addSocks(SocksForm socksForm);

    SocksDto reduceSocks(SocksForm socksForm);

    int getTotalQuantitySocks(String color, String operation, int cottonPart);
}
