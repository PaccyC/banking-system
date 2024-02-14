package org.paccy.bankingsystem.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.paccy.bankingsystem.DAO.AccountDAO;
import org.paccy.bankingsystem.models.Account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/createAccountServlet")
public class CreateAccountServlet  extends HttpServlet {

    private String DATABASE_URL="jdbc:mysql://localhost:3306/banking_system";
    private String USERNAME="root";
    private String PASSWORD="";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection =null;
        Statement statement= null;
//
//        int customerId=Integer.parseInt(request.getParameter("customerId"));

       String type=request.getParameter("type");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            statement =connection.createStatement();

            String query= "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "customer_id INT NOT NULL, "+
                    "type ENUM('current', 'savings') NOT NULL, "+
                    "balance DECIMAL(10,2) NOT NULL DEFAULT 0.00"+
                    ")";

            statement.executeUpdate(query);
            AccountDAO accountDAO= new AccountDAO(connection);
//            accountDAO.addAccount(new Account(customerId,type));

        } catch (ClassNotFoundException  | SQLException e) {
            out.println("Error: "+ e.getMessage());
        }
        finally {
            try {
                if(statement !=null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                out.println("Error: "+ e.getMessage());
            }
        }
        String balance=request.getParameter("balance");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("createAccount.jsp");
        dispatcher.forward(req, resp);
    }
}
