package ru.itis.site.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.site.config.ApplicationConfig;
import ru.itis.site.dto.SearchAccountDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchServlet extends HttpServlet {
    private AccountsService accountsService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        this.accountsService = context.getBean(AccountsService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String query = request.getParameter("query");
        List<SearchAccountDto> accounts = accountsService.search(query);
        writer.println(accounts);
    }
}
