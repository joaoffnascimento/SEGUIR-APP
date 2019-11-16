package br.com.seguirapp.controller;

import br.com.seguirapp.model.Cidade;
import br.com.seguirapp.model.Estado;
import br.com.seguirapp.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/rest/estado")
public class EstadoControler {
    @Autowired
    EstadoRepository er;


    @GetMapping
    public List<Estado> findAll(){
        return er.findAll() ;
    }

}
