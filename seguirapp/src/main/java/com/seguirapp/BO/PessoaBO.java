package com.seguirapp.BO;

import com.seguirapp.model.PessoaModel;
import com.seguirapp.repository.PessoaRepository;
import com.seguirapp.util.ValidaCPF;

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
        ValidaCPF validaCPF = new ValidaCPF();

        if (!validaCPF.isCPF(pessoaModel.getCpf())) {
            throw new Exception("pau");
        }

        if ((pessoaModel.getRg() == null)||(pessoaModel.getRg() == "")) {
            throw new Exception("pau");
        }

        pessoaRepository.save(pessoaModel);
    }
}
