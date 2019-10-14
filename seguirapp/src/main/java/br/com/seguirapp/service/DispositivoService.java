package br.com.seguirapp.service;

import br.com.seguirapp.BO.DispositivoBO;
import br.com.seguirapp.BO.GrupoBO;
import br.com.seguirapp.model.Dispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

    @Autowired
    DispositivoBO dispositivoBO;

    private static DispositivoService myInstance;

    public synchronized static DispositivoService getInstance() {
        if (myInstance == null) {
            myInstance = new DispositivoService();
        }
        return myInstance;
    }

    public Dispositivo createDispositivo(Dispositivo dispositivo) throws Exception{
        return dispositivoBO.createDispositivo(dispositivo);
    }
}
