package com.seguirapp.service;

import com.seguirapp.model.Estado;
import com.seguirapp.model.Pessoa;
import com.seguirapp.model.Pessoa;
import com.seguirapp.repository.PessoaRepository;
import com.seguirapp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PessoaService {
    private static PessoaService myInstance;

    @Autowired
    private PessoaRepository pr;

    public synchronized static PessoaService getInstance() {
        if (myInstance == null) {
            myInstance = new PessoaService();
        }
        return myInstance;
    }

   /* public List<Pessoa> findAll(){
        List<Pessoa> pessoas = new ArrayList<>();
        for (Pessoa pessoa : pr.findAll()) {
            pessoas.add(pessoa);
        }
        return pessoas;
    }*/

   public List<Pessoa> findAll(){
       return pr.findAll();
   }

   public Pessoa findById(int id){
       return pr.findById(id);
   }

    //Validar os atributos da classe
    public void save(Pessoa pessoa) throws Exception {

        Util util = new Util();
        //Validar CPF
        if (!util.isCPF(pessoa.getCpfCnpj())) {
            throw new Exception("Deu pau ao cadastrar CPF inválido !");
        }
        //Validar EMAIL
        if (!util.isEmail(pessoa.getEmail())) {
            throw new Exception("Deu pau ao cadastrar Email Inválido!");
        }
        pr.save(pessoa);
    }

    public void delete(int id){
        pr.deleteById(id);
    }

    /*//Listar Pessoas
    public ModelAndView findAll() {
        //Busca dos eventos no banco de dados
        ModelAndView mv = new ModelAndView();
        //Lista de pessoas
        //Pessoas Repository - metodo de busca, findAll
        Iterable<Pessoa> pessoas = pr.findAll();
        //Atributo mv - para aparecer as coisas na tela
        //Mesmo nome entre chaves e cifrao ${} atributeName
        mv.addObject("pessoas", pessoas);
        return mv;
    }*/

}
