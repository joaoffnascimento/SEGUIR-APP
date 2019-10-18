package br.com.seguirapp;

import br.com.seguirapp.controller.LocalizacaoController;
import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.util.LerCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeguirappApplication {

	@Autowired
	static LocalizacaoController l;

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SeguirappApplication.class, args);
	}

}
