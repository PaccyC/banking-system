package org.paccy.bankingsystem.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.paccy.bankingsystem.DAO.AccountDAO;
import org.paccy.bankingsystem.models.Account;


@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String DATABASE_URL="jdbc:mysql://localhost:3306/banking_system";
    private String USERNAME="root";
    private String PASSWORD="";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection =null;
        Statement statement= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            statement =connection.createStatement();
            AccountDAO accountDAO = new AccountDAO(connection);
            Account account = (Account) accountDAO.getAccountByCustomerId(accountId);
//            account.deposit(amount);
//            accountDAO.updateAccount(account);
            response.sendRedirect("deposit-success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
