package br.com.seguirapp.service;

import br.com.seguirapp.model.Dispositivo;
import br.com.seguirapp.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoDAO;

    private static DispositivoService myInstance;

    public synchronized static DispositivoService getInstance() {
        if (myInstance == null) {
            myInstance = new DispositivoService();
        }
        return myInstance;
    }

    //CADA DISPOSITIVO DEVE ESTAR ASSOCIADO A APENAS UMA PESSOA
    //DEVE POSSUIR UM CODIGO DE IDENTIFICACAO UNICO

    public Dispositivo createDispositivo (Dispositivo dispositivo){

        // Determia as letras que poderão estar presente nas chaves
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for( int i = 0; i < 9; i++ ) {
            index = random.nextInt( letras.length() );
            armazenaChaves += letras.substring( index, index + 1 );
        }
        dispositivo.setIdentificador(armazenaChaves);
        return dispositivoDAO.save(dispositivo);
    }

    public void deleteDispositivo(int id){
        dispositivoDAO.deleteById(id);
    }

}
