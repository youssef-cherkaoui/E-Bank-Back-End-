package com.bank.Service;

import com.bank.Model.Carte;

import java.util.List;

public interface CarteService {
    Carte creerCart(String numero_carte,
                       String date_dexpiration,
                       String Type_carte,
                       int idUser);
    List<Carte> getAllCarte();
    void activerCarte(int idCarte);
    void desactiverCarte(int idCarte);
}
