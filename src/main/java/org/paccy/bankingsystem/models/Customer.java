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


    public Customer(String name, String age) {
        this.name=name;
        this.age=age;
    }


}
