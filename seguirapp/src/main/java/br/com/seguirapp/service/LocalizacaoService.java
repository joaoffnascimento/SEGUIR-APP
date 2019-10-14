package br.com.seguirapp.service;


import br.com.seguirapp.BO.LocalizacaoBO;
import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.repository.LocalizacaoRepository;
import br.com.seguirapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class LocalizacaoService {
    @Autowired
    LocalizacaoBO localizacaoBO;

    public Localizacao create(Localizacao localizacao) throws Exception{
        return localizacaoBO.createLocalizacao(localizacao);
    }

    public Localizacao findById(int id) throws Exception{
        return localizacaoBO.findById(id);
    }

    public List<Localizacao> findAll(){
        return localizacaoBO.findAll();
    }
}
