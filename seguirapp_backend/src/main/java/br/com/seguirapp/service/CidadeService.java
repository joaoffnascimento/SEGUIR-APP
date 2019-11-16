package br.com.seguirapp.service;

import br.com.seguirapp.model.Cidade;
import br.com.seguirapp.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cr;

    public List<Cidade> getAll() {
        return cr.findAll();
    }

    public List<Cidade> getByIdEstado(int id){
        return cr.findCidadeByEstadoIdEstado(id);
    }
}
