package br.com.seguirapp.controller;

import br.com.seguirapp.model.Cidade;
import br.com.seguirapp.model.Pessoa;
import br.com.seguirapp.repository.CidadeRepository;
import br.com.seguirapp.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/rest/cidade")

public class CidadeController {
    @Autowired
    CidadeService cs;

    @GetMapping
    public List<Cidade> findAll(){
        return cs.getAll();
    }


}
