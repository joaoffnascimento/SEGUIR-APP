package br.com.seguirapp.service;

import br.com.seguirapp.BO.PessoaBO;
import br.com.seguirapp.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaBO pessoaBO;

    public boolean create(Pessoa pessoa) throws Exception{
        pessoaBO.save(pessoa);
        return true;
    }

}
