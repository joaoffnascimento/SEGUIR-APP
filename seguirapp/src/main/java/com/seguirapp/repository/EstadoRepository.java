package com.seguirapp.repository;

import com.seguirapp.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoModel, Integer> {
}
