package br.edu.ifs.seguir.controller;

import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PessoaController {

    @GetMapping("/seguir/sample")
    public String sample(){
        return "sample";
    }
}
