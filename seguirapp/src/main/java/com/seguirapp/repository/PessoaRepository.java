package com.seguirapp.repository;

import com.seguirapp.modelHibernate.PessoaModel;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<PessoaModel, String> {
    //instanciar e utilizar metodos ja prontos
    //salvar, deletar, update e etc

}
