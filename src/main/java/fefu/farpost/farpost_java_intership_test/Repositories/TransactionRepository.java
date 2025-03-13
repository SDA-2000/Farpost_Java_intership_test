package fefu.farpost.farpost_java_intership_test.Repositories;

import fefu.farpost.farpost_java_intership_test.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import fefu.farpost.farpost_java_intership_test.Models.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
    List<Transaction> findByAccountAndDateBetween(Account account, LocalDate date1, LocalDate date2);
}
