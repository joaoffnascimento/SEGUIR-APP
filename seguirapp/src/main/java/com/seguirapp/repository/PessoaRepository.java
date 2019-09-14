package com.seguirapp.repository;

import com.seguirapp.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
    //instanciar e utilizar metodos ja prontos
    //salvar, deletar, update e etc

}
