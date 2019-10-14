package br.com.seguirapp.BO;

import br.com.seguirapp.model.*;
import br.com.seguirapp.repository.PessoaRepository;
import br.com.seguirapp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaBO {

    @Autowired
    private PessoaRepository pessoaDAO;

    public PessoaBO(PessoaRepository pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }


    //Validar os atributos da classe
    public Pessoa save(Pessoa pessoa) throws Exception {
        Util util = new Util();
        //Validar CPF

        if (!util.isValid(pessoa.getCpfCnpj())) {
            throw new Exception("Deu pau ao cadastrar CPF inválido !");
        }

        //Validar TELEFONE
//        if(!util.isTelefone(pessoa.getTelefone())){
//            throw new Exception("Deu pau ao cadastrar Telefone Inválido!");
//        }

        //Validar EMAIL
        if(!util.isEmail(pessoa.getUsuario().getEmail())){
            throw new Exception("Deu pau ao cadastrar email invalido!");
        }
        return pessoaDAO.save(pessoa);
    }

    public Pessoa vinculoDependente(Pessoa pessoa, Grupo grupo) throws Exception{
        pessoa.setGrupo(grupo);
        return pessoaDAO.save(pessoa);
    }

    public List<String> dependentes(Grupo grupo){
        return pessoaDAO.getDependentes(grupo.getIdGrupo());
    }

    public void deleteById(int id){
        pessoaDAO.deleteById(id);
    }
}