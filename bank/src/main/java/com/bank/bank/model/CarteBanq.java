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
public class CarteBanq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdCarte;
    private String numCarte;
    private String dateExpir;
    private String typeCarte;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "IdCompte", nullable = false)
    private Compte compte;
}
