package fefu.farpost.farpost_java_intership_test.Repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import fefu.farpost.farpost_java_intership_test.Models.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
    List<Transaction> findByAccountIdAndDateBetween(Long accountId, LocalDate date1, LocalDate date2, Sort sort);
}
