package fefu.farpost.farpost_java_intership_test.Controllers;

import fefu.farpost.farpost_java_intership_test.Models.Account;
import fefu.farpost.farpost_java_intership_test.Repositories.AccountRepository;
import fefu.farpost.farpost_java_intership_test.Services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam String name)
    {
        return ResponseEntity.ok(accountService.createAccount(name));
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getCurrentBalance(@PathVariable Long id)
    {
        return ResponseEntity.ok(accountService.getCurrentBalance(id));
    }

    @GetMapping("/{id}/balance_on_date")
    public ResponseEntity<BigDecimal> getBalanceOnDate(@PathVariable Long id, @RequestParam @DateTimeFormat LocalDate date)
    {
        return ResponseEntity.ok(accountService.getBalanceOnDate(id, date));
    }
}
