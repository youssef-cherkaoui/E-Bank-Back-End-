package com.bank.Controller;

import com.bank.Model.Carte;
import com.bank.Service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carte")
public class CarteController {


    @Autowired
    private CarteService carteService;

    @GetMapping("/afficheCarte")
    public List<Carte> getAllCarte() {
        return carteService.getAllCarte();
    }

    @PostMapping("/creatCarte")
    public Carte creerCarte(@RequestBody Map<String, Object> payload) {
        String numero_carte = (String) payload.get("numero_carte");
        String date_dexpiration = (String) payload.get("date_dexpiration");
        String Type_carte = (String) payload.get("Type_carte");
        int idUser = ((Number) payload.get("idUser")).intValue();

        return carteService.creerCart(numero_carte, date_dexpiration, Type_carte, idUser);
    }


    @PostMapping("/{idCarte}/activer")
    public String activerCarte(@PathVariable int idCarte) {
        carteService.activerCarte(idCarte);
        return "activated";
    }

    @PostMapping("/{idCarte}/desactivated")
    public String desactiverCarte(@PathVariable int idCarte) {
        carteService.desactiverCarte(idCarte);
        return "desactivated";
    }
}
