package org.paccy.bankingsystem.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.paccy.bankingsystem.DAO.CustomerDAO;
import org.paccy.bankingsystem.models.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/createCustomerServlet")
public class RegistrationServlet  extends HttpServlet {
    private static final long serialVersionUID=1L;
//        Variables of database connection
 private String DATABASE_URL="jdbc:mysql://localhost:3306/banking_system";
 private String USERNAME="root";
 private String PASSWORD="";


    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection=null;
        Statement statement = null;

        String name=request.getParameter("name");
        String age=request.getParameter("age");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

            statement =connection.createStatement();
            String query="CREATE TABLE IF NOT EXISTS customers("+
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL, "+
                    "age VARCHAR(5) NOT NULL"+
                    ")";


            statement.executeUpdate(query);
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customerDAO.addCustomer(new Customer(name, age));



        }
        catch (ClassNotFoundException | SQLException e){
            out.println("Error: "+e.getMessage());
        }
        finally {
            try{
                if (statement != null)statement.close();
                if(connection !=null) connection.close();
            } catch (SQLException e) {
             out.println("Error: " +e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req,resp);
    }
}
