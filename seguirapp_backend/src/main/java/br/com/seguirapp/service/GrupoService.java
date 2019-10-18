package br.com.seguirapp.service;

import br.com.seguirapp.BO.GrupoBO;
import br.com.seguirapp.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    @Autowired
    GrupoBO grupoBO;

    private static GrupoService myInstance;

    public synchronized static GrupoService getInstance() {
        if (myInstance == null) {
            myInstance = new GrupoService();
        }
        return myInstance;
    }

    public Grupo createGroup(String nome){
        Grupo grupo = new Grupo(nome);
        return grupoBO.createGroup(nome);
    }

    public void updateGroup(String nome, String newNome){
        grupoBO.update(nome, newNome);
    }

    public void delete(int id){
        grupoBO.delete(id);
    }

}
