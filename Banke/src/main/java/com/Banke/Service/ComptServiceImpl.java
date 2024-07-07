package com.Banke.Service;

import com.Banke.Model.Compt;
import com.Banke.Repository.ComptRepository;
import com.Banke.Repository.UserRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComptServiceImpl implements ComptService {

    @Autowired
    private ComptRepository comptRepository;

    @Autowired
    private UserRepository userRepository;
    private UserServiceImpl userService;


    @Override
    public Compt creatcompt(Compt compte) {
        Compt compt = new Compt();
        compt.setType_compt(compte.getType_compt());
        compt.setSold(compte.getSold());
        compt.setDate_creation(LocalDate.now());
        compt.setUtilisateur(compte.getUtilisateur());
        return comptRepository.save(compt);
    }

    @Override
    public Compt getcomptbyid(Integer id) {
        return comptRepository.findById(id).orElse(null);
    }

    @Override
    public List<Compt> getAllcompt() {
        return comptRepository.findAll();
    }

    @Override
    public void deletecompt(Integer id) {
        comptRepository.deleteById(id);
    }

    @Override
    public Float getSoldById(Integer id) {
        Compt compt = comptRepository.findById(id).orElse(null);
        return (compt != null) ? compt.getSold() : null;
    }


    @Override
    public void fermerCompte(Integer id, String raisonFermeture) {
        Compt compte = comptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        // Logique pour fermer le compte
        System.out.println("Fermeture du compte avec ID: " + id);
        System.out.println("Raison de la fermeture: " + raisonFermeture);

        compte.setFermee(true);
        //ComptService.save(compte);
        comptRepository.save(compte);
    }





}
