package fefu.farpost.farpost_java_intership_test.Services;

import fefu.farpost.farpost_java_intership_test.Models.Account;
import fefu.farpost.farpost_java_intership_test.Models.Transaction;
import fefu.farpost.farpost_java_intership_test.Repositories.AccountRepository;
import fefu.farpost.farpost_java_intership_test.Repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService
{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void MakeTransaction(Long accountId, Double amount, String description, Transaction.TransactionType type)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));

        if(type == Transaction.TransactionType.REMOVE && account.getBalance() < amount)
        {
            throw new RuntimeException("Недостаточно стредств");
        }
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setDate(LocalDate.now());
        transaction.setType(type);

        transactionRepository.save(transaction);

        if(type == Transaction.TransactionType.ADD)
            account.setBalance(account.getBalance() + amount);
        else
            account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);
    }

    @Transactional
    public void MakeTransaction(Long accountId, Double amount, String description, LocalDate date,  Transaction.TransactionType type)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));

        if(type == Transaction.TransactionType.REMOVE && account.getBalance() < amount)
        {
            throw new RuntimeException("Недостаточно стредств");
        }
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setDate(date);
        transaction.setType(type);

        transactionRepository.save(transaction);

        if(type == Transaction.TransactionType.ADD)
            account.setBalance(account.getBalance() + amount);
        else
            account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);
    }

    public List<Transaction> getTransactions(Long accountId, LocalDate date1, LocalDate date2)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return transactionRepository.findByAccountIdAndDateBetween(account.getId(), date1, date2, Sort.by(Sort.Direction.ASC, "date"));
    }
}
