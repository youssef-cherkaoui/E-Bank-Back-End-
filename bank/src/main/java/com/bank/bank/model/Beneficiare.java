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
public class Beneficiare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdBeneficiare;
    private String nom;
    private String numeroCompte;
    private String nomBanq;

    @ManyToOne
    @JoinColumn(name = "IdCompte", nullable = false)
    private Compte compte;
}
