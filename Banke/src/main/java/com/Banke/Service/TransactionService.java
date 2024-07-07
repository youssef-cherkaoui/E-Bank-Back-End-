package com.Banke.Service;

import org.hibernate.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsByIdCompt(Integer idcompt);
}
