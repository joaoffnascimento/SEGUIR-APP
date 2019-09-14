package com.seguirapp.repository;

import com.seguirapp.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository <Cidade, Integer> {
}
