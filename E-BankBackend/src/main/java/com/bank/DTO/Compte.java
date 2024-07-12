package com.bank.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    private String type_compte;
    private double solde_initial;
    private String date_creation;
    private int idUser;
}
