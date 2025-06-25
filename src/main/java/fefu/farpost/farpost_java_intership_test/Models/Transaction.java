package fefu.farpost.farpost_java_intership_test.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JsonBackReference
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
