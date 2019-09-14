package com.seguirapp.seguirapp;

import com.seguirapp.model.Auth;
import com.seguirapp.model.Cidade;
import com.seguirapp.model.Pessoa;
import com.seguirapp.repository.PessoaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.Oneway;
import java.sql.Date;
import java.sql.SQLData;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeguirappApplicationTests {
	@Autowired
	PessoaRepository pr;

	@Test
	public void contextLoads() {
	}

	@Test
	public void cadastrarPessoa(){
		try{
			Auth auth = new Auth();
			Cidade lagarto = new Cidade();
			lagarto.setIdCidade(5383);
			auth.setIdAuth(1);
			Pessoa p = new Pessoa();
			p.setNome("João Felipe");
			p.setCpf("07293475594");
			p.setAuthByAuth(auth);
			p.setCidadeByCidade(lagarto);
			p.setEmail("thecurrentuser@live.com");
			p.setLogradouro("Rua Coronel Souza Freire");
			p.setRg("123");
			p.setSexo("Masculino");
			p.setTelefone("(79)99685-9817");
			pr.save(p);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
