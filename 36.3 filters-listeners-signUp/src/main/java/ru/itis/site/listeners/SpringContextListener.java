package ru.itis.site.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.site.config.ApplicationConfig;
import ru.itis.site.services.AccountService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // при запуске контекста получили его
        // контекст сервлетов имеет доступ ко всем сервлетам и наоборот
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext springContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // положил в контекст сервлетов атрибут контекст спринга
        servletContext.setAttribute("springContext", springContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
