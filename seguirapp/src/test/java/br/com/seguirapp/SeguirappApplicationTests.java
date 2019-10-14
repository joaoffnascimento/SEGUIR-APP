package br.com.seguirapp;

import br.com.seguirapp.model.*;
import br.com.seguirapp.repository.CidadeRepository;
import br.com.seguirapp.service.*;
import br.com.seguirapp.util.LerCSV;
import br.com.seguirapp.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
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
    //--------------------------------------------------------------------------//

    @Autowired
    VeiculoService veiculoService;


    @Test
    public void createVeiculo() throws Exception{

        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setIdDispositivo(1);
        dispositivo.setIdentificador("abcd1234");
        dispositivo.setNome("Dubom");
        Veiculo veiculo = new Veiculo();
        veiculo.setCor("Vermelho");
        veiculo.setDispositivo(dispositivo);
        veiculo.setMarca("Chevrolet");
        veiculo.setModelo("Cruze");
        veiculo.setPlaca("ABC-1234");

        veiculoService.createVeiculo(veiculo);

    }
    //VEICULO BO
    //--------------------------------------------------------------------------//

    @Autowired
    DispositivoService dispositivoService;

    @Test
    public void createDispositivo() throws Exception{
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setIdentificador("abcd1234");
        dispositivo.setNome("Dubom");
        dispositivoService.createDispositivo(dispositivo);

    }

    //CADASTRAR DISPOSITIVO OK, ELE GERA UM CODIGO AUTOMATICO UNICO PARA CADA PESSOA
    //A LOCALIZACAO ESTA RELACIONADA AO DISPOSITIVO E O DISPOSITIVO A PESSOA
    //--------------------------------------------------------------------------//

}