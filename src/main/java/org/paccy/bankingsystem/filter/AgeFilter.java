package org.paccy.bankingsystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.logging.LogRecord;

@WebFilter("/register")
public class AgeFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }

   @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String ageParam = httpRequest.getParameter("age");
       PrintWriter out= response.getWriter();

        if (ageParam != null) {
            int age = Integer.parseInt(ageParam);
            if (age >= 18) {
                // Age is valid, proceed with the request
                chain.doFilter(request, response);
            } else {
                // Age is invalid, display an error message
                out.println("You must be at least 18 years old to register.");
                request.setAttribute("errorMessage", "You must be at least 18 years old to register.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Age parameter not found, display an error message
            request.setAttribute("errorMessage", "Age parameter is missing.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }
    }

}
