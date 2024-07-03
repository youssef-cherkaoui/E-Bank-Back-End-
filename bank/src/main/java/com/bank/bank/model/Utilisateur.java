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
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdUtilisateur;
    private String nom;
    private String email;
    private String motdepasse;
    private String numeroTelephone;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Compte> comptes;
}
