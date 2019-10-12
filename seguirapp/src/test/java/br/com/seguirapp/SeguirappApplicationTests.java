package br.com.seguirapp;

import br.com.seguirapp.model.Cidade;
import br.com.seguirapp.repository.CidadeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeguirappApplicationTests {

	@Autowired
	CidadeRepository cr;
	@Test
	public void contextLoads() {
		Cidade c = cr.findById(25).get();
		System.out.print(c);
		System.out.println(cr.getCidadesByIdEstado(1));
	}

}
