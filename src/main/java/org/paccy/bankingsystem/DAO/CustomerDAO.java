package org.paccy.bankingsystem.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.paccy.bankingsystem.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDAO {

    private Connection connection;



    public void  addCustomer(Customer customer) throws SQLException {
        String query= "INSERT INTO customers (name,email,age,password,accountType,balance) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement statement=connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2,customer.getEmail());
            statement.setString(3,customer.getAge());
            statement.setString(4,customer.getPassword());
            statement.setString(5,customer.getAccountType());
            statement.setDouble(6,customer.getBalance());
            statement.executeUpdate();
        }

    }
//    Retrieving all customers from the database
    public List<Customer> getAllCustomers() throws SQLException {

        List<Customer> customers= new ArrayList<>();
        String query="SELECT * FROM customers";
        try (PreparedStatement statement=connection.prepareStatement(query);
             ResultSet resultSet=statement.executeQuery()
        ){
  while (resultSet.next()){
      int id=resultSet.getInt("id");
      String name= resultSet.getString("name");
      String email=resultSet.getString("email");
      String age=resultSet.getString("age");
      String password=resultSet.getString("password");
      String accountType=resultSet.getString("accountType");
      Double balance=resultSet.getDouble("balance");
      customers.add(new Customer(name,email,age,password,accountType,balance));
  }

        }
        return customers;
    }
    public Customer getCustomerById(String customerId) throws SQLException {
        String query = "SELECT * FROM customers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String age = resultSet.getString("age");
                    String password = resultSet.getString("password");
                    String accountType = resultSet.getString("accountType");
                    double balance = resultSet.getDouble("balance");
                    return new Customer(name, email, age, password, accountType, balance);
                } else {
                    // Customer not found
                    return null;
                }
            }
        }
    }
    public boolean withdraw(String userId,double amount) throws SQLException {
        String query= "UPDATE customers SET balance = balance - ? WHERE id=?";
        try (PreparedStatement statement=connection.prepareStatement(query)){
            statement.setDouble(1,amount);
            statement.setString(2,userId);
            int rowsUpdated=statement.executeUpdate();
            return rowsUpdated >0;
        }
        catch (SQLException e){
            e.printStackTrace();
            return  false;
        }
    }

}
