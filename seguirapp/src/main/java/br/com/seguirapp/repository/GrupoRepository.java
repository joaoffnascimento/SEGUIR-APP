package br.com.seguirapp.repository;

import br.com.seguirapp.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    void deleteByEmpresa(String empresa);
}
