package ru.itits.site.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itits.site.forms.SignUpForm;
import ru.itits.site.models.Account;
import ru.itits.site.repositories.AccountsRepository;
import ru.itits.site.utils.EmailUtil;

import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Qualifier("forMailsFreemarkerConfiguration")
    @Autowired
    private Configuration configuration;

    @Transactional
    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .state(Account.State.NOT_CONFIRMED)
                .confirmId(UUID.randomUUID().toString())
                .build();

        sendConfirmMail(account);

        accountsRepository.save(account);
    }

    private void sendConfirmMail(Account account) {
        try {
            Template template = configuration.getTemplate("mails/confirm_mail.ftlh");
            Map<String, String> attributes = Collections.singletonMap("confirm_id", account.getConfirmId());
            StringWriter writer = new StringWriter();
            template.process(attributes, writer);
            emailUtil.sendMail(writer.toString(), "??????????????????????", account.getEmail());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
