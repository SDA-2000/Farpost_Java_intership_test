package fefu.farpost.farpost_java_intership_test.Repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import fefu.farpost.farpost_java_intership_test.Models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
    List<Transaction> findByAccountIdAndDateBetween(Long accountId, LocalDate date1, LocalDate date2, Sort sort);

    @Query("""
    select sum(case when t.type = 0 then t.amount
               else t.amount*(-1)
               end) 
from Transaction t
where t.account.id = :accountId and t.date < :beforeDate
""")
    BigDecimal getBalanceBeforeDate(@Param("accountId") Long accountId, @Param("beforeDate") LocalDate beforeDate);

}
