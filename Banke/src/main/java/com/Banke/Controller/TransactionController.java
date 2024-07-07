package com.Banke.Controller;

import com.Banke.Model.Utilisateur;
import com.Banke.Service.TransactionService;
import com.Banke.Service.TransactionServiceImpl;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trans")

public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;


    // Obtenir toutes les transactions d'un compte par ID
    @GetMapping("/compte/{idcompt}")
    public ResponseEntity<List<Transaction>> getTransactionsByIdCompt(@PathVariable Integer idcompt) {

        List<Transaction> transactions = transactionService.getTransactionsByIdCompt(idcompt);

        if (transactions != null && !transactions.isEmpty()) {
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
