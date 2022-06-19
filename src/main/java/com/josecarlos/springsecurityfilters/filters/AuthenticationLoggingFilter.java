package com.josecarlos.springsecurityfilters.filters;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        var httpRequest = (HttpServletRequest) servletRequest;
//
//        var requestId = httpRequest.getHeader("Request-Id");
//
//        logger.info("Successfully authenticated request with id %s".formatted(requestId));
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var httpRequest = request;

        var requestId = httpRequest.getHeader("Request-Id");

        logger.info("Successfully authenticated request with id %s".formatted(requestId));

        filterChain.doFilter(request, response);
    }
}
