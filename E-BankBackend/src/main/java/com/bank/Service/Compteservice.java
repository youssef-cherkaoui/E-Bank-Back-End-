package com.bank.Service;

import com.bank.Model.compte;

import java.util.List;

public interface Compteservice {

    compte creerCompte(String type_compte,
                       Float Solde_initial,
                       String Date_creation,
                       int idUser);

    List<compte> getAllComptes();
    double getCompteSold(int idCompte);
    void fermerCompte(int idCompte, String raisonFermeture);
}