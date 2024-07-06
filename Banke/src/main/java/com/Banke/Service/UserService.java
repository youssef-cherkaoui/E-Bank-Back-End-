package com.Banke.Service;
import com.Banke.Model.Compt;
import com.Banke.Model.Utilisateur;
import com.Banke.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    public Utilisateur getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public Utilisateur createuser(Utilisateur u) {
        Utilisateur utilisateur = new Utilisateur();
        u.setFullname_user(utilisateur.getFullname_user());
        u.setPassword_user(utilisateur.getPassword_user());
        u.setMail_user(utilisateur.getMail_user());
        return userRepository.save(u);

    }
}
