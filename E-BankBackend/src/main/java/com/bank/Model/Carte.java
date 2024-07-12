package com.bank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id_carte;
    private String numero_carte;
    private String date_dexpiration;
    private String Type_carte;
    private boolean active;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

}
