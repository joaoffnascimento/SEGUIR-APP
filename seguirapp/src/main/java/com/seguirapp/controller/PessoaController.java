package com.seguirapp.controller;

import com.seguirapp.modelHibernate.PessoaModel;
import com.seguirapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PessoaController {

	//Intejção de dependencias
	//Todas vez que for necessario utilizar essa interface
	//sera utilizada a instancia criada automaticamente
	@Autowired
	private PessoaRepository pr;

	//metodo get, retorna o formulario
	@RequestMapping(value="/cadastroPessoa", method = RequestMethod.GET)
	public String form() {
		return "cadastros/formPessoa";
	}

	//metodo post, salvar o formulario
	@RequestMapping(value="/cadastroPessoa", method = RequestMethod.POST)
	public String form(PessoaModel pessoaModel) {
		//Persistir o evento no banco de dados
		pr.save(pessoaModel);
		return "redirect:/formPessoa";
	}
	
}
