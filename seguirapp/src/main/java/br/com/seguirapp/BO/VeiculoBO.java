package br.com.seguirapp.BO;

import br.com.seguirapp.repository.UsuarioRepository;
import br.com.seguirapp.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoBO {

    @Autowired
    private VeiculoRepository veiculoDAO;

    public VeiculoBO(VeiculoRepository veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }
}
