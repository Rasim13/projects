package ru.itis.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.model.UniqueWords;
import ru.itis.repositories.WordRepository;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Parser {

    @Autowired
    private WordRepository wordRepository;

    public List<String> getListOfIterators() {
        ArrayList<String> listOfSeparators = new ArrayList<String>();
        listOfSeparators.add(" ");
        listOfSeparators.add("\"");
        listOfSeparators.add(",");
        listOfSeparators.add(".");
        listOfSeparators.add("!");
        listOfSeparators.add("?");
        listOfSeparators.add("(");
        listOfSeparators.add(")");
        listOfSeparators.add("[");
        listOfSeparators.add("]");
        listOfSeparators.add("-");
        listOfSeparators.add(";");
        listOfSeparators.add(":");
        listOfSeparators.add("\n");
        listOfSeparators.add("\r");
        listOfSeparators.add("\t");
        return listOfSeparators;
    }

    public void parser(String url) {
        String separatorsString = String.join("|\\", getListOfIterators());
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        try {
            Document doc = Jsoup.parse(new URL(url), 3000);
            String str = doc.text();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8))));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(separatorsString);
                for (String word : words) {
                    int count = 0;
                    if ("".equals(word)) {
                        continue;
                    }
                    for (String word1 : words) {
                        if (word.equalsIgnoreCase(word1)) {
                            count++;
                        }
                    }
                    countMap.put(word, count);
                }
            }

            reader.close();
            for (Map.Entry<String, Integer> pair : countMap.entrySet()) {
                UniqueWords uniqueWords = new UniqueWords();
                uniqueWords.setWord(pair.getKey());
                uniqueWords.setAmountOfWord(pair.getValue());
                wordRepository.save(uniqueWords);
            }
        } catch (
                IOException e) {
            throw new IllegalArgumentException();

        }

    }




}
