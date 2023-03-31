package com.raza.simplesecurity.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/29
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class TestFilter extends GenericFilterBean{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("username");
        System.out.println(username);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
