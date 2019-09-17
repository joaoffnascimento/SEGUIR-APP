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

    /*Save*/
    public Pessoa save(Pessoa p) throws Exception{

        Util util = new Util();
        //Validar CPF
        if (!util.isCPF(p.getCpfCnpj())) {
            throw new Exception("Deu pau ao cadastrar CPF inválido !");
        }
        //Validar EMAIL
        if (!util.isEmail(p.getEmail())) {
            throw new Exception("Deu pau ao cadastrar Email Inválido!");
        }
        return pr.save(p);
    }

    /*Delete*/
    public void delete(Pessoa p){
        pr.delete(p);
    }
    /*Update*/


    /*Select All*/
    public List<Pessoa> findAll(){
        return pr.findAll();
    }

    /*Select By Id*/
    public Pessoa findById(int id){
        return pr.findById(id);
    }

}
