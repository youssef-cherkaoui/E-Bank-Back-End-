package com.Banke.Controller;

import com.Banke.Model.Compt;
import com.Banke.Service.ComptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/compt")
public class ComptController {

    @Autowired
     ComptServiceImpl comptService;

    @GetMapping("/")
    public List<Compt> getCompts() {
        return comptService.getAllcompt();
    }

    @GetMapping("/{id}")
    public Compt getCompt(@PathVariable Integer id) {
        return comptService.getcomptbyid(id);

    }

    @PostMapping("/add")
    public Compt addCompt(@RequestBody Compt compt){


        return  comptService.creatcompt(compt);
    }

    @DeleteMapping("/{id}")
    public String deleteCompt(@PathVariable Integer id) {
        comptService.deletecompt(id);
        return "deleted";
    }
    @GetMapping("/{id}/sold")
    public Float getComptSold(@PathVariable Integer id) {
        return comptService.getSoldById(id);
    }


    @PostMapping("/fermer")
    public String fermerCompte(@RequestBody Map<String, Object> payload) {
        int idcompt = ((Number) payload.get("idcompt")).intValue();
        String raisonFermeture = (String) payload.get("raisonFermeture");

        comptService.fermerCompte(idcompt, raisonFermeture);

        return "Compte fermé avec succès";
    }

}
