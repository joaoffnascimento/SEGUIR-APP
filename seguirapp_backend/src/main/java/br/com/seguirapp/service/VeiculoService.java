package br.com.seguirapp.service;

import br.com.seguirapp.model.Veiculo;
import br.com.seguirapp.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoDAO;

    private static VeiculoService myInstance;

    public synchronized static VeiculoService getInstance() {
        if (myInstance == null) {
            myInstance = new VeiculoService();
        }
        return myInstance;
    }

    //SO IRA CRIAR O VEICULO SE EXISTIR UM DISPOSITIVO PARA SER ASSOCIADO

    public Veiculo createVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getDispositivo() == null) {
            throw new Exception("Veiculo so sera cadastrado se existir algum dispositivo a ser associado!");
        }
        return veiculoDAO.save(veiculo);
    }

    public void deleteVeiculo(int id) {
        veiculoDAO.deleteById(id);
    }

    //POSSIBILIDADE DE ALTERAR A PLACA DO VEICULO
    public Veiculo updatePlaca(Veiculo veiculo, String placa) throws Exception{
        if(placa == null){
            throw  new Exception("Placa invalida");
        }
        return veiculoDAO.updatePlaca(veiculo.getPlaca(), placa);
    }

    //POSSIBILIDADE DE ALTERAR A COR DO VEICULO
    public Veiculo updateCor(Veiculo veiculo, String cor) throws Exception{
        if(cor == null){
            throw  new Exception("Cor deve ser alterada para algo !");
        } else if (cor == veiculo.getCor()){
            throw new Exception("O veiculo já é dessa cor !");
        }
        return veiculoDAO.updateCor(veiculo.getCor(), cor);
    }


}
