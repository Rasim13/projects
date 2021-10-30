package ru.itis.accountingSocks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.accountingSocks.dto.SocksDto;
import ru.itis.accountingSocks.exceptions.EnterIncorrectDataException;
import ru.itis.accountingSocks.forms.SocksForm;
import ru.itis.accountingSocks.services.SocksService;

@RestController
public class SocksController {


    private SocksService socksService;

    @Autowired
    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping("api/socks/income")
    public SocksDto addSocks(@RequestBody SocksForm socksFrom) {

        if (socksFrom.getQuantity() > 0 && socksFrom.getCottonPart() > 0 && socksFrom.getCottonPart() <= 100) {
            return socksService.addSocks(socksFrom);
        } else {
            throw new EnterIncorrectDataException(socksFrom);
        }
    }

    @PostMapping("api/socks/outcome")
    public SocksDto reduceSocks(@RequestBody SocksForm socksForm) {

        if (socksForm.getQuantity() > 0 ) {

            return socksService.reduceSocks(socksForm);

        } else {
            throw new EnterIncorrectDataException(socksForm);
        }
    }

    @GetMapping("api/socks")
    public int getTotalNumberSocks(@RequestParam("color") String color,
                                   @RequestParam("operation") String operation,
                                   @RequestParam("cottonPart") int cottonPart) {
        return socksService.getTotalQuantitySocks(color, operation, cottonPart);
    }

}
