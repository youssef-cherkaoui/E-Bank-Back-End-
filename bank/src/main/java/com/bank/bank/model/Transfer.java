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
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdTransfer;
    private float montant;
    private String date;
    private String motif;



    @ManyToOne
    @JoinColumn(name = "IdsourceCompte", nullable = false)
    private Compte sourceCompte;

    @ManyToOne
    @JoinColumn(name = "IdcibleCompte", nullable = false)
    private Compte targetCompte;
}
