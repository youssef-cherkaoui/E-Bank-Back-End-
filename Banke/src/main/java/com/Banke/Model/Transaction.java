package com.Banke.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdTransaction;
    private float montant;
    private String type_transaction;
    private String motif;
    private String date;


    @ManyToOne
    @JoinColumn(name="compte_id", nullable=false)
    private Compt compte;

}
