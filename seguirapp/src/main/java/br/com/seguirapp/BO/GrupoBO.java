package br.com.seguirapp.BO;

import br.com.seguirapp.model.Grupo;
import br.com.seguirapp.repository.GrupoRepository;
import br.com.seguirapp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoBO {

    @Autowired
    private GrupoRepository grupoDAO;

    public GrupoBO(GrupoRepository grupoDAO) {
        this.grupoDAO = grupoDAO;
    }

    public Grupo createGroup(String nome){
        Grupo g = new Grupo(nome);
        return grupoDAO.save(g);
    }

    public void delete(String nome){
        grupoDAO.deleteByEmpresa(nome);
    }

}
