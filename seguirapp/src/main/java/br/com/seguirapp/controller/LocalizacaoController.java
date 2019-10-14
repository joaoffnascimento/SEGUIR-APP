package br.com.seguirapp.controller;

import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.service.LocalizacaoService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/localizacao")
public class LocalizacaoController {
    @Autowired
    LocalizacaoService localizacaoService;


    @PostMapping(path = "/cadastrar")
    public ResponseEntity setLocalizacao(@RequestBody Localizacao localizacao) throws Exception {
        return new ResponseEntity(localizacaoService.create(localizacao), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getLocalizacaoById/{id}")
    public ResponseEntity<?> obterLocalizacao(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<Localizacao>(localizacaoService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Localizacao> findAll(){
        return localizacaoService.findAll();
    }


    @RequestMapping(value = "/post", method =  RequestMethod.POST)
    public Localizacao Post(@Valid @RequestBody Localizacao localizacao)throws Exception {
        return localizacaoService.create(localizacao);
    }
}
