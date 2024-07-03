package com.bank.bank.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdTransaction;
    private String date;
    private float montant;
    private String type;
    private String description;

    @ManyToOne
    @JoinColumn(name = "IdCompte", nullable = false)
    private Compte compte;
}
