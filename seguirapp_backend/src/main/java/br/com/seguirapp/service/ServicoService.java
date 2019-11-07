package br.com.seguirapp.service;

import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.model.Servico;
import br.com.seguirapp.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoDAO;

    private static ServicoService myInstance;

    public synchronized static ServicoService getInstance() {
        if (myInstance == null) {
            myInstance = new ServicoService();
        }
        return myInstance;
    }

    public Servico createServico(Servico servico){
        return servicoDAO.save(servico);
    }

    public void deleteServico(int id){
        servicoDAO.deleteById(id);
    }

    public ArrayList<String> consultaLocalizacao(int idDispositivo){
        return servicoDAO.getLocalizacao(idDispositivo);
    }

}
