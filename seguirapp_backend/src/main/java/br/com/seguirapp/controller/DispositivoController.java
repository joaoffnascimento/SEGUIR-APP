package br.com.seguirapp.controller;

import br.com.seguirapp.model.Dispositivo;
import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/rest/dispositivo")
public class DispositivoController {

    @Autowired
    DispositivoService ds;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity setLocalizacao(@RequestBody Dispositivo dispositivo) throws Exception {
        return new ResponseEntity(ds.createDispositivo(dispositivo), HttpStatus.CREATED);
    }

    @GetMapping(path = "/busca/{id}")
    public ResponseEntity<?> getDispositivo(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<String>((MultiValueMap<String, String>) ds.getDispositivo(), HttpStatus.OK);
    }
}
