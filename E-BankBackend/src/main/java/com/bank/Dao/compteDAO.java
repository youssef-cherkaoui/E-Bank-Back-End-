package com.bank.Dao;

import com.bank.Model.compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface compteDAO  extends JpaRepository<compte, Integer> {

}
