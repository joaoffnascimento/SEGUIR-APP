package com.seguirapp.repository;

import com.seguirapp.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, String> {
    //instanciar e utilizar metodos ja prontos
    //salvar, deletar, update e etc

}
