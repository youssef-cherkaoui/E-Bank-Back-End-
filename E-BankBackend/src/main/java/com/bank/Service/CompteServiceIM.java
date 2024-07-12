package com.bank.Service;

import com.bank.Dao.compteDAO;
import com.bank.Dao.userDAO;
import com.bank.Model.User;
import com.bank.Model.compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceIM implements Compteservice {

    @Autowired
    private compteDAO comptedao;

    @Autowired
    private userDAO userdao;

    private  compteDAO daoC;

    @Override
    public compte creerCompte(String typeCompte, Float soldeInitial, String dateCreation, int idUser) {
        User user = userdao.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found"));

        compte compte = new compte();
        compte.setType_compte(typeCompte);
        compte.setSolde_initial(soldeInitial);
        compte.setDate_creation(dateCreation);
        compte.setUser(user); // Associer l'utilisateur au compte

        return comptedao.save(compte);
    }

    @Override
    public List<compte> getAllComptes() {
        return comptedao.findAll();
    }

    @Override
    public double getCompteSold(int idCompte) {
        compte compte = comptedao.getReferenceById(idCompte);

        return compte.getSolde_initial();
    }

    @Override
    public void fermerCompte(int idCompte, String raisonFermeture) {
        compte compte = comptedao.findById(idCompte)
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        // Logique pour fermer le compte
        System.out.println("Fermeture du compte avec ID: " + idCompte);
        System.out.println("Raison de la fermeture: " + raisonFermeture);

        compte.setFermee(true);
        comptedao.save(compte);
    }


    public void Transaction(String Montant, int idCompte){

        Optional<compte> compte = daoC.findById(idCompte);


    }
}
