package com.Banke.Service;

import com.Banke.Repository.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public  List<Transaction> getTransactionsByIdCompt(Integer idcompt) {
        return transactionRepository.findByidcompt(idcompt);

    }


}
