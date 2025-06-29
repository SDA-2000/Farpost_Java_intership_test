package fefu.farpost.farpost_java_intership_test.Services;

import fefu.farpost.farpost_java_intership_test.Models.Account;
import fefu.farpost.farpost_java_intership_test.Models.Transaction;
import fefu.farpost.farpost_java_intership_test.Repositories.AccountRepository;
import fefu.farpost.farpost_java_intership_test.Repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final  TransactionRepository transactionRepository;

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

    public BigDecimal getBalanceOnDate(Long accountId, LocalDate date)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        BigDecimal balance_account = transactionRepository.getBalanceBeforeDate(accountId, date);
        return balance_account;
    }
}
