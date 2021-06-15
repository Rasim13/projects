package ru.itis.site.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.site.forms.SignUpForm;
import ru.itis.site.services.SignUpService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) servletContext.getAttribute("springContext");
        this.signUpService = springContext.getBean(SignUpService.class);
    }

    private SignUpService signUpService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignUpForm form = SignUpForm.builder()
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();

        signUpService.signUp(form);

        // открываем страничку входа (это делает браузер, переходит на страницу signIn)
        response.setHeader("Location", "/signIn");
        response.setStatus(302);
//        response.sendRedirect("/signIn");
    }
}
