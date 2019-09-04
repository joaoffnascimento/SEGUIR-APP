package com.seguirapp.BO;

import com.seguirapp.model.PessoaModel;
import com.seguirapp.repository.PessoaRepository;
import com.seguirapp.util.Util;

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
        Util util = new Util();
        //Validar CPF
        if (!util.isCPF(pessoaModel.getCpf())) {
            throw new Exception("Deu pau ao cadastrar CPF inválido !");
        }
        //Validar EMAIL
        if(!util.isEmail(pessoaModel.getEmail())){
            throw new Exception("Deu pau ao cadastrar Email Inválido!");
        }
        pessoaRepository.save(pessoaModel);
    }
}
