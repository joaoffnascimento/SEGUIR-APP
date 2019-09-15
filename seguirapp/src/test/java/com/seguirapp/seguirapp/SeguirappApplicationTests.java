package com.seguirapp.seguirapp;

import com.seguirapp.model.Auth;
import com.seguirapp.model.Cidade;
import com.seguirapp.model.Pessoa;
import com.seguirapp.service.PessoaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeguirappApplicationTests {
	@Autowired
	PessoaService ps;

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
			p.setCpfCnpj("07293475594");
			p.setAuthByIdAuth(auth);
			p.setCidadeByIdCidade(lagarto);
			p.setEmail("thecurrentuser@live.com");
			p.setLogradouro("Rua Coronel Souza Freire");
			p.setRg("123");
			p.setSexo("Masculino");
			p.setTelefone("(79)996859817");
			ps.save(p);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
