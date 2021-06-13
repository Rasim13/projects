package ru.itis.site.servlets;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.site.config.ApplicationConfig;
import ru.itis.site.dto.AccountDto;
import ru.itis.site.services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        this.accountService = context.getBean(AccountService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AccountDto> accounts = accountService.getAll();
        // устанавливаем атррибут и кладем список
        request.setAttribute("accounts", accounts);
        // отправляем в jsp страницу
        request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);
//        StringBuilder html = new StringBuilder();
//        html.append("<table>" +
//                "    <tr>" +
//                "       <th>ID</th>" +
//                "       <th>FIRST NAME</th>" +
//                "       <th>LAST NAME</th>" +
//                "       <th>EMAIL</th>" +
//                "    </tr>");
//        for (AccountDto account: accounts) {
//            html.append("<tr>");
//            html.append("<td>").append(account.getId()).append("</td>");
//            html.append("<td>").append(account.getFirstName()).append("</td>");
//            html.append("<td>").append(account.getLastName()).append("</td>");
//            html.append("<td>").append(account.getEmail()).append("</td>");
//            html.append("</tr>");
//        }
//        html.append("</table>");
//        response.getWriter().println(html.toString());

    }
}
