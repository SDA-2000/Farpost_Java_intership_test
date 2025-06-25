package fefu.farpost.farpost_java_intership_test.Controllers;

import fefu.farpost.farpost_java_intership_test.Models.Transaction;
import fefu.farpost.farpost_java_intership_test.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("accounts/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> getTransactionBetweenDates(@PathVariable Long id,
                                                                        @RequestParam @DateTimeFormat LocalDate date1,
                                                                        @RequestParam @DateTimeFormat LocalDate date2)
    {
        return ResponseEntity.ok(transactionService.getTransactions(id, date1, date2));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> MakeTransaction(@PathVariable Long id,
                                                  @RequestParam Double amount,
                                                  @RequestParam String description,
                                                  @RequestParam Transaction.TransactionType type)
    {
        transactionService.MakeTransaction(id, amount, description, type);
        return ResponseEntity.ok("Операция выполнена");
    }

    @PostMapping("/{id}/with_time")
    public  ResponseEntity<String> MakeTransaction(@PathVariable Long id,
                                                   @RequestParam Double amount,
                                                   @RequestParam String description,
                                                   @RequestParam @DateTimeFormat LocalDate date,
                                                   @RequestParam Transaction.TransactionType type)
    {
        transactionService.MakeTransaction(id, amount, description, date, type);
        return  ResponseEntity.ok("Операция выполнена");
    }
}
