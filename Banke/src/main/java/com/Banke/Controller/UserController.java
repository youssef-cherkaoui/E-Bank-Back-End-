package com.Banke.Controller;

import com.Banke.Model.Utilisateur;
import com.Banke.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable int id) {
        Utilisateur user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/add")
    public Utilisateur addUser(@RequestBody Utilisateur user) {
        return userService.createuser(user);
    }


}
