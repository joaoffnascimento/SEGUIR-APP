package br.com.seguirapp.BO;

import br.com.seguirapp.model.Localizacao;
import br.com.seguirapp.model.Servico;
import br.com.seguirapp.repository.PessoaRepository;
import br.com.seguirapp.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoBO {
    @Autowired
    private ServicoRepository servicoDAO;

    public ServicoBO(ServicoRepository servicoDAO) {
        this.servicoDAO = servicoDAO;
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
