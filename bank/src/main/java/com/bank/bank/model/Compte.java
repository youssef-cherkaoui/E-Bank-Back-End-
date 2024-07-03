package com.bank.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCompte")
    private long IdCompte;
    private String TypeCompte;
    private String DateCreation;
    private Float Solde;

    @ManyToOne
    @JoinColumn(name = "IdUtilisateur", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "compte")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "compte")
    private Set<CarteBanq> cartes;

    @OneToMany(mappedBy = "compte")
    private Set<Beneficiare> beneficiaires;

    @OneToMany(mappedBy = "sourceCompte")
    private Set<Transfer> IdsourceCompte;

    @OneToMany(mappedBy = "targetCompte")
    private Set<Transfer> IdcibleCompte;
}
