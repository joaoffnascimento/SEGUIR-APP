package br.com.seguirapp.service;

import br.com.seguirapp.BO.PessoaBO;
import br.com.seguirapp.BO.ServicoBO;
import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    ServicoBO servicoBO;

    private static ServicoService myInstance;

    public synchronized static ServicoService getInstance() {
        if (myInstance == null) {
            myInstance = new ServicoService();
        }
        return myInstance;
    }

    public Servico createServico(Servico servico){
        return servicoBO.createServico(servico);
    }

    public void deleteServico(int id){
        servicoBO.deleteServico(id);
    }

    public ArrayList<String> consultaLocalizacao(int idDispositivo){
        return servicoBO.consultaLocalizacao(idDispositivo);
    }



}
