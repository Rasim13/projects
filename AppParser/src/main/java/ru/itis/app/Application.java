package ru.itis.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.config.Configuration;
import ru.itis.model.UniqueWords;
import ru.itis.repositories.WordRepository;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        WordRepository wordRepository = context.getBean(WordRepository.class);

        String url = "https://www.simbirsoft.com/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements sentences = doc.select("meta > content");
            for (Element el: sentences) {
                String title = el.ownText();
                UniqueWords word = new UniqueWords();
                word.setWord(title);
                wordRepository.save(word);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error");
        }

    }
}
