package fefu.farpost.farpost_java_intership_test.Services;

import fefu.farpost.farpost_java_intership_test.Models.Account;
import fefu.farpost.farpost_java_intership_test.Models.Transaction;
import fefu.farpost.farpost_java_intership_test.Repositories.AccountRepository;
import fefu.farpost.farpost_java_intership_test.Repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final TransactionRepository transactionRepository;

    public Account createAccount(String name)
    {
        Account account = new Account();
        account.setName(name);
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    public double getCurrentBalance(Long accountId)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return account.getBalance();
    }

    public double getBalanceOnDate(Long accountId, LocalDate date)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        double balance_count = 0.0;

        for(Transaction transaction : account.getTransactions())
        {
            if(!transaction.getDate().isAfter(date))
            {
                if(transaction.getType() == Transaction.TransactionType.ADD)
                    balance_count += transaction.getAmount();
                else
                    balance_count -= transaction.getAmount();
            }
        }
        return balance_count;
    }
}
