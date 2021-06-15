package ru.itis.site.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(LocalDateTime.now() + " " + request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
