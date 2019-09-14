package com.seguirapp.service;

import com.seguirapp.model.PessoaModel;
import com.seguirapp.repository.PessoaRepository;
import com.seguirapp.util.Util;

public class PessoaService {
    private static PessoaService myInstance;

    public synchronized static PessoaService getInstance() {
        if (myInstance == null) {
            myInstance = new PessoaService();
        }
        return myInstance;
    }

    //Validar os atributos da classe
    public void salvar(PessoaModel pessoaModel, PessoaRepository pessoaRepository) throws Exception {
        Util util = new Util();
        //Validar CPF
        if (!util.isCPF(pessoaModel.getCpf())) {
            throw new Exception("Deu pau ao cadastrar CPF inválido !");
        }
        //Validar EMAIL
        if (!util.isEmail(pessoaModel.getEmail())) {
            throw new Exception("Deu pau ao cadastrar Email Inválido!");
        }
        //Validar TELEFONE
        if(!util.isTelefone(pessoaModel.getTelefone())){
            throw new Exception("Deu pau ao cadastrar Telefone Inválido!");
        }
        pessoaRepository.save(pessoaModel);
    }
}
