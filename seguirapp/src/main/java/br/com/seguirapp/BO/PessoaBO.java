package br.com.seguirapp.BO;

import br.com.seguirapp.model.Pessoa;
import br.com.seguirapp.repository.PessoaRepository;
import br.com.seguirapp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaBO {

    @Autowired
    private PessoaRepository pessoaDAO;

    public PessoaBO(PessoaRepository pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }


    //Validar os atributos da classe
    public void save(Pessoa pessoa) throws Exception {
        Util util = new Util();
        //Validar CPF

        if (!util.isValid(pessoa.getCpfCnpj())) {
            throw new Exception("Deu pau ao cadastrar CPF inválido !");
        }

        //Validar TELEFONE
        if(!util.isTelefone(pessoa.getTelefone())){
            throw new Exception("Deu pau ao cadastrar Telefone Inválido!");
        }
        pessoaDAO.save(pessoa);
    }
}