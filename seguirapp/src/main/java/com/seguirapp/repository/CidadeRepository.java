package com.seguirapp.repository;

import com.seguirapp.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository <CidadeModel, Integer> {
}
