package com.seguirapp.controller;

import com.seguirapp.model.Pessoa;
import com.seguirapp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexRestController {

    @Autowired
    PessoaService ps;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String formCadastroPessoa(ModelMap model) {
        Pessoa pessoa = new Pessoa();
        model.addAttribute("pessoa", pessoa);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String salvarRegistroPessoa(@Valid Pessoa pessoa, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) throws Exception {

        ps.save(pessoa);
        return "redirect:/viewpessoas";
    }

   /* @RequestMapping(value = "/viewpessoas")
    public ModelAndView getAll() {
        List<Pessoa> list = ps.findAll();
        return new ModelAndView("viewpessoas", "list", list);
    }*/

    @RequestMapping(value="/viewpessoas")
    public ModelAndView getAll() {

        List<Pessoa> pessoas=ps.findAll();
        return new ModelAndView("viewpessoas", "pessoas", pessoas);
    }

    @RequestMapping(value = "/editpessoa/{id}")
    public String edit(@PathVariable int id, ModelMap model) {
        Pessoa pessoa = ps.findById(id);
        model.addAttribute("pessoas", pessoa);
        return "editpessoa";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("pessoa") Pessoa p) throws Exception {
        Pessoa pessoa = ps.findById(p.getIdPessoa());

        pessoa.setNome(pessoa.getNome());
        pessoa.setDtNascimento(pessoa.getDtNascimento());
        pessoa.setDtCadastro(pessoa.getDtCadastro());
        pessoa.setRg(pessoa.getRg());
        pessoa.setCpfCnpj(pessoa.getCpfCnpj());
        pessoa.setSexo(pessoa.getSexo());
        pessoa.setEmail(pessoa.getEmail());
        pessoa.setTelefone(pessoa.getTelefone());
        pessoa.setLogradouro(pessoa.getLogradouro());
        pessoa.setPessoaByIdResponsavel(pessoa.getPessoaByIdResponsavel());
        pessoa.setAuthByIdAuth(pessoa.getAuthByIdAuth());
        pessoa.setCidadeByIdCidade(pessoa.getCidadeByIdCidade());

        ps.save(pessoa);
        return new ModelAndView("redirect:/viewpessoas");
    }

    @RequestMapping(value = "deletepessoa/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        Pessoa p = ps.findById(id);
        ps.delete(p);
        return new ModelAndView("redirect:/viewpessoa");
    }

    @ModelAttribute("cidades")
    public List<String> initializeCidades() {
        List<String> cidades = new ArrayList<String>();
        cidades.add("Lagarto");
        return cidades;
    }

    @ModelAttribute("estados")
    public List<String> initalizeEstados() {
        List<String> estados = new ArrayList<String>();
        estados.add("Sergipe");
        return estados;
    }
}
