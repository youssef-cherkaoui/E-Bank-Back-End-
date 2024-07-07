package com.Banke.Service;

import com.Banke.Model.Compt;
import org.hibernate.Transaction;

import java.util.List;

public interface ComptService {

    Compt creatcompt(Compt compte);

    Compt getcomptbyid(Integer id);

    List<Compt> getAllcompt();

    void deletecompt(Integer id);

    Float getSoldById(Integer id);

    void fermerCompte(Integer id, String raisonFermeture);
}

