package com.Banke.Service;

import com.Banke.Model.Utilisateur;

import java.util.List;

public interface UserService {

    List<Utilisateur> getAllUsers();

    Utilisateur getUserById(int id);

    Utilisateur createuser(Utilisateur u);


}
