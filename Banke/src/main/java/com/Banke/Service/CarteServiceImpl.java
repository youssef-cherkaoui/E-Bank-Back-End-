package com.Banke.Service;

import com.Banke.Model.Carte;
import com.Banke.Repository.CarteRepository;
import com.Banke.Repository.ComptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteServiceImpl implements CarteService {

    @Autowired
    private CarteRepository carteRepository;

    @Autowired
    private ComptRepository compteRepository;


    @Override
    public Carte creerCarte(Carte carte) {
        Carte newCarte = new Carte();
        newCarte.setNumeroCarte(carte.getNumeroCarte());
        newCarte.setTypeCarte(carte.getTypeCarte());
        newCarte.setDateExpiration(carte.getDateExpiration());
        newCarte.setCompte(carte.getCompte());
        newCarte.setActive(true); // Initialement active
        return carteRepository.save(newCarte);
    }

    @Override
    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    @Override
    public Carte getCarteById(int id) {
        return carteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCarte(int id) {
        carteRepository.deleteById(id);
    }

    @Override
    public void activerCarte(int id) {
        Carte carte = carteRepository.findById(id).orElse(null);
        if (carte != null) {
            carte.setActive(true);
            carteRepository.save(carte);
        }
    }

    @Override
    public void desactiverCarte(int id) {
        Carte carte = carteRepository.findById(id).orElse(null);
        if (carte != null) {
            carte.setActive(false);
            carteRepository.save(carte);
        }
    }
}
