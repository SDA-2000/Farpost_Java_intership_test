package fefu.farpost.farpost_java_intership_test.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="account_id", nullable = false)
    private Account account;
    private double amount;
    private String description;
    private LocalDate date;
    private TransactionType type;

    public enum TransactionType {
        ADD, REMOVE
    };
}
