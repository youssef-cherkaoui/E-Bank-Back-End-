package com.bank.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;
    private String type_compte;
    private Float Solde_initial;
    private String Date_creation;
    private  boolean Fermee;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

   @JsonIgnore
   @OneToMany(mappedBy="compte")
    private Set<Transaction> transactions;
}
