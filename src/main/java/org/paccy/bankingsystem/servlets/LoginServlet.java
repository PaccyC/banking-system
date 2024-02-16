package org.paccy.bankingsystem.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
    private String DATABASE_URL="jdbc:mysql://localhost:3306/banking_system";
    private String USERNAME="root";
    private String PASSWORD="";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        Connection connection=null;
        String name= req.getParameter("name");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        RequestDispatcher dispatcher=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);



            PreparedStatement ps=connection.prepareStatement("SELECT * FROM customers WHERE name=? and password=?");
            ps.setString(1,name);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                session.setAttribute("name",rs.getString("name"));
//                resp.sendRedirect("index.jsp");
                dispatcher=req.getRequestDispatcher("index.jsp");
            }
            else {
                out.println("<h4>Sorry, username or password is incorrect! </h4>");
               req.setAttribute("status","failed");
               req.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(req,resp);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req,resp);
    }
}
