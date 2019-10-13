package br.com.seguirapp;

import br.com.seguirapp.model.Cidade;
import br.com.seguirapp.model.Grupo;
import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.model.Usuario;
import br.com.seguirapp.repository.CidadeRepository;
import br.com.seguirapp.service.GrupoService;
import br.com.seguirapp.service.LocalizacaoService;
import br.com.seguirapp.service.UsuarioService;
import br.com.seguirapp.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeguirappApplicationTests {

    @Autowired
    UsuarioService usuarioService;

    //BO USUARIO OK

    @Test
    public void createUser() throws Exception {
        usuarioService.create("rayssa@bol.com", "dcba");
        System.out.println(usuarioService.findByEmail("rayssa@bol.com"));
    }

    @Test
    public void UpdateEmailUser() throws Exception {
        Usuario user = new Usuario("thecurrentuser@gmail.com", "abcd1234");
        usuarioService.updateEmail(user, "testeupdate@gmail.com");
        System.out.println(usuarioService.findByEmail("testeupdate@gmail.com"));
    }

    @Test
    public void updatePassword() throws Exception {
        Usuario user = new Usuario("felipe@bol.com", "abcd1234");
        usuarioService.updatePassword(user, "abcd123567");
    }

    @Test
    public void delete() throws Exception {
        usuarioService.delete("rayssa@bol.com");
    }
    //--------------------------------------------------------------------------//

    @Autowired
    GrupoService grupoService;

    @Test
    public void createGroup() throws Exception {
        grupoService.createGroup("marata");
    }

    @Test
    public void deleteGroup() throws Exception {
        grupoService.delete(2);
    }

    //BO GRUPO OK
    //--------------------------------------------------------------------------//


    @Autowired
    LocalizacaoService localizacaoService;

//    @Test
//    public void inserirPos() throws Exception {
//        localizacaoService.create((new java.sql.Date(new java.util.Date().getTime())),"-10906181511598900", "-37061850152271500", "0.21687925979495049");
//    }

    // BO Localizacao OK
}