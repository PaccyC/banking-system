package org.paccy.bankingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private int customerId;
    private String type;
    private double balance;

    public Account(int customerId, String type) {
        this.customerId=customerId;
        this.type=type;
    }
}
