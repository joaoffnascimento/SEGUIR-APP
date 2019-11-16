package br.com.seguirapp.repository;

import br.com.seguirapp.model.Cidade;
import br.com.seguirapp.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
