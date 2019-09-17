package com.seguirapp.controller;

import com.seguirapp.model.Pessoa;
import com.seguirapp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.sql.Date;

@Controller
public class IndexRestController {

    @Autowired
    PessoaService pessoaService;

    /*@GetMapping(value = "/") //Dir, root
    public String home() {
        return "/index.html"; //nmTemplate
    }

    @GetMapping("/all-pessoas")
    @ResponseBody
    public String listarPessoas() {
        return pessoaService.findAll().toString();
    }

    @GetMapping("/save-pessoa")
    @ResponseBody
    public String salvarPessoa(@RequestParam String nome, @RequestParam Date dtNascimento, @RequestParam String cpfCnpj, @RequestParam
            String rg, @RequestParam String sexo, @RequestParam Date dtCadastro, @RequestParam String email, @RequestParam String logradouro,
                               @RequestParam String telefone) {
        Pessoa pessoa = new Pessoa(nome, dtNascimento, cpfCnpj, rg, sexo, dtCadastro, email, logradouro, telefone);
        return "Pessoa Salva!";
    }

    @GetMapping("/delete-pessoa")
    @ResponseBody
    public String deletePessoa(@RequestParam int id) {
        pessoaService.delete(id);
        return "Pessoa apagada!";
    }*/

    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/pessoa");
        mv.addObject("pessoa", pessoaService.findAll());

        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Pessoa pessoa) {

        ModelAndView mv = new ModelAndView("/pessoaAdd");
        mv.addObject("pessoa", pessoa);

        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {

        return add(pessoaService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {

        pessoaService.delete(id);
        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return add(pessoa);
        }

        pessoaService.save(pessoa);
        return findAll();
    }
}
