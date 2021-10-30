package ru.itis.accountingSocks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.accountingSocks.dto.SocksDto;
import ru.itis.accountingSocks.exceptions.EnterLargeNumberOfException;
import ru.itis.accountingSocks.exceptions.NotFoundNumberException;
import ru.itis.accountingSocks.forms.SocksForm;
import ru.itis.accountingSocks.models.Socks;
import ru.itis.accountingSocks.repositories.SocksRepository;

import java.util.Optional;

import static ru.itis.accountingSocks.dto.SocksDto.from;

@Service
public class SocksServiceImpl implements SocksService {


    private SocksRepository socksRepository;

    @Autowired
    public SocksServiceImpl(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    @Override
    @Transactional
    public SocksDto addSocks(SocksForm socksForm) {

        Optional<Socks> socksOptional = socksRepository.findByColorAndCottonPart(socksForm.getColor(), socksForm.getCottonPart());

        if (socksOptional.isPresent()) {

            Socks socks = socksOptional.get();

                socks.setColor(socksForm.getColor());
                socks.setCottonPart(socksForm.getCottonPart());
                socks.setQuantity(socks.getQuantity() + socksForm.getQuantity());
                socksRepository.save(socks);
                return from(socks);

        } else {

            Socks newSocks = new Socks();
            newSocks.setQuantity(socksForm.getQuantity());
            newSocks.setCottonPart(socksForm.getCottonPart());
            newSocks.setColor(socksForm.getColor());
            socksRepository.save(newSocks);
            return from(newSocks);
        }
    }

    @Override
    @Transactional
    public SocksDto reduceSocks(SocksForm socksForm) {

        Socks socks = null;

        Optional<Socks> socksOptional = socksRepository.findByColorAndCottonPart(socksForm.getColor(), socksForm.getCottonPart());

        if (socksOptional.isPresent()) {

            socks = socksOptional.get();

            if (socks.getQuantity() == 0) {
                throw new NotFoundNumberException(socks);
            }

            if (socks.getQuantity() >= socksForm.getQuantity()) {
                    socks.setColor(socksForm.getColor());
                    socks.setCottonPart(socksForm.getCottonPart());
                    socks.setQuantity(socks.getQuantity() - socksForm.getQuantity());
                    socksRepository.save(socks);

                } else {
                    throw new EnterLargeNumberOfException(socksForm);
                }

            } else {

            throw new IllegalArgumentException("Not found");
        }
        return from(socks);
        }

    @Override
    public int getTotalQuantitySocks(String color, String operation, int cottonPart) {
        int totalNumberSocks = 0;

        if (operation.equals("moreThan")) {
             return totalNumberSocks = socksRepository.getQuantitySocksByColorEqualAndCottonPartMoreThan(color, cottonPart);
        }

        if (operation.equals("lessThan")) {
           return totalNumberSocks = socksRepository.getQuantitySocksByColorEqualAndCottonPartLessThan(color, cottonPart);
        }

        if (operation.equals("equal")) {
            return totalNumberSocks = socksRepository.getQuantitySocksByColorEqualAndCottonPartEqual(color, cottonPart);
        }

        return -1;
    }
}
