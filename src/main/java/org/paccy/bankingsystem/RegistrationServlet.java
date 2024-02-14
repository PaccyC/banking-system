package org.paccy.bankingsystem;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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


    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection=null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

            statement =connection.createStatement();
            String query="CREATE TABLE customers("+
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL, "+
                    "age INT NOT NULL"+
                    ")";


            statement.executeUpdate(query);

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
}
