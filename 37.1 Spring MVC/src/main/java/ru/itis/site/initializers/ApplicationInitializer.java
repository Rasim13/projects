package ru.itis.site.initializers;

import lombok.SneakyThrows;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.itis.site.config.ApplicationConfig;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// класс WebApplicationInitializer будет автоматически подгружаться TomCat
public class ApplicationInitializer implements WebApplicationInitializer {

    @SneakyThrows
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // подружить контекст спринга с контекстом сервлетов
        AnnotationConfigWebApplicationContext springWebContext = new AnnotationConfigWebApplicationContext();

        // запустить контекст с нужным профилем (dev or production)
        PropertySource propertySource = new ResourcePropertySource("classpath:application.properties");
        String profile = (String) propertySource.getProperty("spring.profile.active");
        //загружаем активный профайл
        springWebContext.getEnvironment().setActiveProfiles(profile);


        //поместили наш конфигурационный класс в контекст спринга
        springWebContext.register(ApplicationConfig.class);
        //добавляем в слушатель контекста сервлетов контекст спринга
        // т.о., при страте веб-приложения контекст сприга тоже будет запущен
        servletContext.addListener(new ContextLoaderListener(springWebContext));
        //зарегистрируем DispatcherServlet
        //создаем сервлет
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springWebContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        // он будет загружаться первым
        dynamic.setLoadOnStartup(1);
        // будет регировать на все url
        dynamic.addMapping("/");
    }
}
