package br.com.seguirapp.repository;

import br.com.seguirapp.model.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public interface CidadeRepository extends JpaRepository <Cidade, Integer> {
    List<Cidade> findCidadeByEstadoIdEstado(int id);
}
