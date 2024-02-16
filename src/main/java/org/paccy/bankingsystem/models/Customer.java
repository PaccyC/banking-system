package org.paccy.bankingsystem.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int id;
    private String name;
    private String age;
   private String password;
   private String email;
   private String accountType;
   private double balance;

    public Customer(String name, String age, String password) {
        this.name=name;
        this.age=age;
        this.password=password;

    }


    public Customer(String name, String email, String age, String password, String accountType, Double balance) {
        this.name=name;
        this.email=email;
        this.age=age;
        this.password=password;
        this.accountType=accountType;
        this.balance=balance;
    }
}
