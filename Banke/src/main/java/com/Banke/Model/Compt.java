package com.Banke.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Compt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcompt;
    private String type_compt;
    private float sold;
    private LocalDate date_creation;


    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


    @JsonIgnore
    @OneToMany(mappedBy = "IdTransaction")
    private Set<Transaction> transactions;

//    @OneToMany(mappedBy = "utilisateur")
//    @JsonIgnore
//    private List<Compt> compt_list ;



}
