package com.seguirapp.service;

import com.seguirapp.model.Cidade;
import com.seguirapp.model.Estado;
import com.seguirapp.repository.CidadeRepository;
import com.seguirapp.repository.EstadoRepository;
import com.seguirapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {

    private static CidadeService myInstance;

    @Autowired
    private CidadeRepository cr;

    @Autowired
    private EstadoRepository er;

    public synchronized static CidadeService getInstance() {
        if (myInstance == null) {
            myInstance = new CidadeService();
        }
        return myInstance;
    }

    public List<String> listarCidadeByEstado(){
        return null;
    }

    public List<String> listarEstados(){
        List<Estado> estados = er.findAll();
        List<String> listEstados = new ArrayList<String>();
        for (Estado estado : estados) {
            listEstados.add(estado.getNome());
        }
        return listEstados;
    }

    public List<Estado> getAllEstados(){
        return er.findAll();
    }
}
