package br.com.seguirapp.controller;

import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.model.Pessoa;
import br.com.seguirapp.repository.PessoaRepository;
import br.com.seguirapp.service.LocalizacaoService;
import br.com.seguirapp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/rest/pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository pr;

    @Autowired
    PessoaService ps;


    @PostMapping(path = "/cadastrar")
    public ResponseEntity setPessoa(@RequestBody Pessoa p) throws Exception {
        return new ResponseEntity(ps.save(p), HttpStatus.CREATED);
    }


    @GetMapping(path = "/getPessoaById/{id}")
    public ResponseEntity<?> obterPessoa(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<Pessoa>(ps.findById(id), HttpStatus.OK);
    }


    @GetMapping(path = "/getPessoa/{id}")
    public ResponseEntity<?> obterPessoaId(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<String>((MultiValueMap<String, String>) ps.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Pessoa> findAll(){
        return ps.getAll();
    }

    @RequestMapping(value = "/post", method =  RequestMethod.POST)
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa)throws Exception {
        return ps.save(pessoa);
    }


}
