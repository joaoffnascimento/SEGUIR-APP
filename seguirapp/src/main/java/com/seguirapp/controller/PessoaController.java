package com.seguirapp.controller;

import com.seguirapp.model.PessoaModel;
import com.seguirapp.repository.PessoaBO;
import com.seguirapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		return "view/formPessoa";
	}

	@RequestMapping(value = "/pau", method = RequestMethod.GET)
	public String form2(){
		return "pau/pau";
	}

	//metodo post, salvar o formulario
	@RequestMapping(value="/cadastroPessoa", method = RequestMethod.POST)
	public String form(PessoaModel pessoaModel) {
		//Persistir o evento no banco de
		try{
			PessoaBO.getInstance().salvar(pessoaModel, pr);

		}catch (Exception e){
			System.out.println(e);
			return "redirect:/pau";
		}
		return "redirect:/cadastroPessoa";
	}

	//Retornar a lista de pessoas cadastradas
	@RequestMapping("/pessoas")
	public ModelAndView listaPessoas(){
		//Busca dos eventos no banco de dados
		ModelAndView mv = new ModelAndView("list\\listaPessoas");
		//Lista de pessoas
		//Pessoas Repository - metodo de busca, findAll
		Iterable<PessoaModel> pessoas = pr.findAll();
		//Atributo mv - para aparecer as coisas na tela
		//Mesmo nome entre chaves e cifrao ${} atributeName
		mv.addObject("pessoas", pessoas);
		return mv;
	}
}
