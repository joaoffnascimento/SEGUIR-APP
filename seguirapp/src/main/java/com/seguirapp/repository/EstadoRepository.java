package com.seguirapp.repository;

import com.seguirapp.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    public Estado findByNome(String nome);
}
