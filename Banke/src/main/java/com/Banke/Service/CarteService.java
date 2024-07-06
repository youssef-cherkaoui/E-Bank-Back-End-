package com.Banke.Service;

import com.Banke.Model.Carte;
import com.Banke.Repository.CarteRepository;
import com.Banke.Repository.ComptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    @Autowired
    private ComptRepository compteRepository;

    public Carte creerCarte(Carte carte) {
        Carte newCarte = new Carte();
        newCarte.setNumeroCarte(carte.getNumeroCarte());
        newCarte.setTypeCarte(carte.getTypeCarte());
        newCarte.setDateExpiration(carte.getDateExpiration());
        newCarte.setCompte(carte.getCompte());
        newCarte.setActive(true); // Initialement active
        return carteRepository.save(newCarte);
    }


    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    public Carte getCarteById(int id) {
        return carteRepository.findById(id).orElse(null);
    }

    public void deleteCarte(int id) {
        carteRepository.deleteById(id);
    }

    public void activerCarte(int id) {
        Carte carte = carteRepository.findById(id).orElse(null);
        if (carte != null) {
            carte.setActive(true);
            carteRepository.save(carte);
        }
    }

    public void desactiverCarte(int id) {
        Carte carte = carteRepository.findById(id).orElse(null);
        if (carte != null) {
            carte.setActive(false);
            carteRepository.save(carte);
        }
    }
}
