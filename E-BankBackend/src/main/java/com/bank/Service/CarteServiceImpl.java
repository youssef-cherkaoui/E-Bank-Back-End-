package com.bank.Service;

import com.bank.Dao.carteDAO;
import com.bank.Dao.userDAO;
import com.bank.Model.Carte;
import com.bank.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteServiceImpl implements CarteService {

    @Autowired
    private carteDAO cartedao;
    @Autowired
    private userDAO userdao;
    @Override
    public Carte creerCart(String numero_carte, String date_dexpiration, String Type_carte, int idUser) {
        User user = userdao.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Carte carte = new Carte();
        carte.setNumero_carte(numero_carte);
        carte.setDate_dexpiration(date_dexpiration);
        carte.setType_carte(Type_carte);
        carte.setUser(user);

        return cartedao.save(carte);
    }

    @Override
    public List<Carte> getAllCarte() {
        return cartedao.findAll();
    }

    @Override
    public void activerCarte(int idCarte) {
        Carte carte = cartedao.findById(idCarte).
                orElseThrow(() -> new RuntimeException("Compte not found"));
        if (carte != null) {
                carte.setActive(true);
                cartedao.save(carte);
        } else {
            throw new RuntimeException("Carte non trouvée.");
        }

    }

    @Override
    public void desactiverCarte(int idCarte) {
        Carte carte = cartedao.findById(idCarte).
                orElseThrow(() -> new RuntimeException("Compte not found"));
        if (carte != null) {
            carte.setActive(false);
            cartedao.save(carte);
        } else {
            throw new RuntimeException("Carte non trouvée.");
        }
    }
}
