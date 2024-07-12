package com.bank.Dao;

import com.bank.Model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carteDAO  extends JpaRepository<Carte, Integer> {
}
