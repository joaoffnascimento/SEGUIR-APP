package br.com.seguirapp.service;

import br.com.seguirapp.model.Grupo;
import br.com.seguirapp.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoDAO;

    private static GrupoService myInstance;

    public synchronized static GrupoService getInstance() {
        if (myInstance == null) {
            myInstance = new GrupoService();
        }
        return myInstance;
    }

    public void save (Grupo g){
        grupoDAO.save(g);
    }

    public void delete(int id){
        grupoDAO.deleteById(id);
    }

    public void update(String nome, String newNome){
        grupoDAO.updateEmpresa(nome, newNome);
    }

}
