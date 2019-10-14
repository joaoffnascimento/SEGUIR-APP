package br.com.seguirapp.service;

import br.com.seguirapp.BO.VeiculoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    VeiculoBO veiculoBO;

}
