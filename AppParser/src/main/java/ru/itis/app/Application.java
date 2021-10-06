package ru.itis.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.config.Configuration;
import ru.itis.parser.Parser;
import ru.itis.repositories.WordRepository;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        WordRepository wordRepository = context.getBean(WordRepository.class);
        Parser parser = context.getBean(Parser.class);
        parser.parser("https://www.simbirsoft.com/");
    }

}
