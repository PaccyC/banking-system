package org.paccy.bankingsystem.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.paccy.bankingsystem.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDAO {
    private Connection connection;
    public void addAccount(Account account) throws SQLException{
        String query="INSERT INTO accounts (customer_id,type,balance) VALUES (?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(query)){
            statement.setInt(1,account.getCustomerId());
            statement.setString(2,account.getType());
            statement.setDouble(3,account.getBalance());
            statement.executeUpdate();
        }
    }

    public List<Account> getAccountByCustomerId(int customerId) throws SQLException{
        List<Account> accounts= new ArrayList<>();
        String query= "SELECT * FROM accounts WHERE customer_id= ?";
        try (PreparedStatement statement=connection.prepareStatement(query)){
            statement.setInt(1,customerId);

            try (ResultSet resultSet=statement.executeQuery()){
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String type=resultSet.getString("type");
                    double balance=resultSet.getDouble("balance");
                    accounts.add(new Account(id,customerId,type,balance));
                }

            }

        }
        return accounts;
    }
}
