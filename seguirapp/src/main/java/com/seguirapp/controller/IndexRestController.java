package com.seguirapp.controller;

import com.seguirapp.model.Pessoa;
import com.seguirapp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class IndexRestController {

    @Autowired
    PessoaService pessoaService;

	@GetMapping(value = "/") //Dir, root
	public String home() {
		return "/index.html"; //nmTemplate
	}

	@GetMapping("/all-pessoas")
	@ResponseBody
	public String listarPessoas(){
	    return pessoaService.findAll().toString();
    }

    @GetMapping("/save-pessoa")
	@ResponseBody
    public String salvarPessoa(@RequestParam String nome, @RequestParam Date dtNascimento, @RequestParam String cpfCnpj, @RequestParam
							   String rg, @RequestParam String sexo, @RequestParam Date dtCadastro, @RequestParam String email, @RequestParam String logradouro,
							   @RequestParam String telefone){
	    Pessoa pessoa = new Pessoa(nome, dtNascimento, cpfCnpj, rg, sexo, dtCadastro, email, logradouro, telefone);
	    return "Pessoa Salva!";
    }

    @GetMapping("/delete-pessoa")
	@ResponseBody
	public String deletePessoa(@RequestParam int id){
		pessoaService.delete(id);
		return "Pessoa apagada!";
	}
}
