package ru.itis.shcedule.security.filters;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.shcedule.security.authentication.TokenAuthentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component("tokenFilterAuthentication")
public class TokenAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String value = request.getHeader("Authorization");
        // создаем объект аутентификации
        Authentication authentication = new TokenAuthentication(value);
        // кладем его в SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // отправили запрос дальше
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
