package br.com.seguirapp.service;

import br.com.seguirapp.BO.VeiculoBO;
import br.com.seguirapp.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    VeiculoBO veiculoBO;

    private static VeiculoService myInstance;

    public synchronized static VeiculoService getInstance() {
        if (myInstance == null) {
            myInstance = new VeiculoService();
        }
        return myInstance;
    }

    public Veiculo createVeiculo(Veiculo veiculo) throws Exception {
        return veiculoBO.createVeiculo(veiculo);
    }

    public void deleteVeiculo(int id) {
        veiculoBO.deleteVeiculo(id);
    }

    public Veiculo updatePlaca(Veiculo veiculo, String placa) throws Exception {
        return veiculoBO.updatePlaca(veiculo, placa);
    }

    public Veiculo updateCor(Veiculo veiculo, String cor) throws Exception {
        return veiculoBO.updateCor(veiculo, cor);
    }

}
