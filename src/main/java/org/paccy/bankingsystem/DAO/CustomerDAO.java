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
        String query= "INSERT INTO customers (name,age) VALUES (?,?)";
        try(PreparedStatement statement=connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2,customer.getAge());
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
      String age=resultSet.getString("age");
      customers.add(new Customer(id,name,age));
  }

        }
        return customers;
    }

}
