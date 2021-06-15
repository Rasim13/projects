package ru.itis.site.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.site.config.ApplicationConfig;
import ru.itis.site.dto.SearchAccountDto;
import ru.itis.site.services.AccountService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/search")
public class SearchServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // внутри сервлета получают доступ к контексту сервлетов
        ServletContext servletContext = servletConfig.getServletContext();
        ApplicationContext springContext = (ApplicationContext) servletContext.getAttribute("springContext");
        this.accountService = springContext.getBean(AccountService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
            String query = request.getParameter("query");
            List<SearchAccountDto> accounts = accountService.search(query);
            writer.println(accounts);
    }
}
