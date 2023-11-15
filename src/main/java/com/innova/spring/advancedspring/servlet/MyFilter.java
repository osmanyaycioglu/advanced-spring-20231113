package com.innova.spring.advancedspring.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/my")
public class MyFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {

        String nameLoc = (String) request.getParameter("name");
        System.out.println("Filtering : " + nameLoc);
        if (nameLoc == null || nameLoc.equals("osman")) {
            HttpServletResponse responseLoc = (HttpServletResponse) response;
            responseLoc.addHeader("Content-Type",
                                  "text/plain;charset=UTF-8");
            responseLoc.getWriter()
                       .println("Boş yada osman giremez ");
            return;
        }
        chain.doFilter(request,
                       response);
    }

    @Override
    public void destroy() {
    }
}
