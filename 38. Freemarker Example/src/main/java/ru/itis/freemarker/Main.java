package ru.itis.freemarker;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_20);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(new FileTemplateLoader(new File("src/main/resources")));

        Template template = configuration.getTemplate("template_for_web.ftlh");

        User user = User.builder()
                .id(1L)
                .age(null)
                .name("Расим")
                .build();

        List<User> users = new ArrayList<>();
        users.add(User.builder().id(2L).age(25).name("Айрат").build());
        users.add(User.builder().id(3L).age(30).name("Даниил").build());
        users.add(User.builder().id(4L).age(19).name("Виктор").build());
        users.add(User.builder().id(5L).age(26).name("Антон").build());
        users.add(User.builder().id(6L).age(24).name("Фарит").build());

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("user", user);
        attributes.put("users", users);

        FileWriter fileWriter = new FileWriter("output.html");
        template.process(attributes, fileWriter);
    }
}
