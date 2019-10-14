package br.com.seguirapp.BO;

import br.com.seguirapp.model.Veiculo;
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
