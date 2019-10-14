package br.com.seguirapp.service;

import br.com.seguirapp.BO.PessoaBO;
import br.com.seguirapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaBO pessoaBO;

    private static PessoaService myInstance;

    public synchronized static PessoaService getInstance() {
        if (myInstance == null) {
            myInstance = new PessoaService();
        }
        return myInstance;
    }

    public Pessoa create(Pessoa pessoa) throws Exception{
        return pessoaBO.save(pessoa);
    }

    public Pessoa vinculoDependente(Pessoa pessoa, Grupo grupo) throws Exception{
        return pessoaBO.save(pessoa);
    }

    public List<String> dependentes(Grupo grupo){
        return pessoaBO.dependentes(grupo);
    }

    public void deletePessoa(int id){
        pessoaBO.deleteById(id);
    }
}
