package ru.itis.site.filters;


import lombok.SneakyThrows;
import ru.itis.site.forms.SignUpForm;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

public class FormConverterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getMethod().equals("POST")) {
            if (request.getMethod().endsWith("/signUp")) {
                Map<String, String[]> body = request.getParameterMap();
                Class<SignUpForm> signUpFormClass = SignUpForm.class;
                SignUpForm form = signUpFormClass.newInstance();
                // получаем все поля формы
                Field[] fields = signUpFormClass.getDeclaredFields();
                // получаем все параметры запроса
                for (String paramName : body.keySet()) {
                    // во все поля вставить значения параметров
                    //signUpFormClass.getDeclaredField(paramName);

                }
                // кладете созданную форму как атрибут запроса
                request.setAttribute("form", form);

            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
