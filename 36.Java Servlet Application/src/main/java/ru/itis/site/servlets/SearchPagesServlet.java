package ru.itis.site.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.site.config.ApplicationConfig;
import ru.itis.site.dto.SearchAccountDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchPagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<form action=\"http://localhost/admin/search\">\n" +
                "\t<input type=\"text\" name=\"query\">\n" +
                "\t<br>\n" +
                "\t<input type=\"submit\" value=\"Search\">\n" +
                "</form>");
    }
}
