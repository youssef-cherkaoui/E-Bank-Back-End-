package com.Banke.Service;
import com.Banke.Model.Utilisateur;
import com.Banke.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Utilisateur getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Utilisateur createuser(Utilisateur u) {
        Utilisateur utilisateur = new Utilisateur();
        u.setFullname_user(utilisateur.getFullname_user());
        u.setPassword_user(utilisateur.getPassword_user());
        u.setMail_user(utilisateur.getMail_user());
        return userRepository.save(u);

    }
}
