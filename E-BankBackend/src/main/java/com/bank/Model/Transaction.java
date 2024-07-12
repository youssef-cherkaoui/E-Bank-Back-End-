package com.bank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Transaction;
    private String Date_heure;
    private double Montant;
    private String Type_transaction;
    private String description;

    @ManyToOne
    @JoinColumn(name="idCompte", nullable=false)
    private compte compte;
}
