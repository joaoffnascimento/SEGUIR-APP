package com.seguirapp.repository;

import com.seguirapp.model.PessoaModel;

public class PessoaBO {
    private static PessoaBO myInstance;

    public synchronized static PessoaBO getInstance() {
        if (myInstance == null) {
            myInstance = new PessoaBO();
        }
        return myInstance;
    }
    //Validar os atributos da classe
    public void salvar(PessoaModel pessoaModel, PessoaRepository pessoaRepository) throws Exception {
        if ((pessoaModel.getCpf() == null)||(pessoaModel.getCpf() == "")) {
            throw new Exception("pau");
        }
        pessoaRepository.save(pessoaModel);
    }
}
