package br.com.seguirapp.service;

import br.com.seguirapp.BO.UsuarioBO;
import br.com.seguirapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioBO usuarioBO;

    public Usuario create(String email, String senha) throws Exception{
        return usuarioBO.createUser(email, senha);
    }

    public Usuario findByEmail(String email){
        return usuarioBO.findByEmail(email);
    }

    public void updateEmail(Usuario usuario, String newEmail) throws Exception{
        usuarioBO.updateEmail(usuario, newEmail);
    }

    public void updatePassword(Usuario usuario, String newPass) throws Exception{
        usuarioBO.updateSenha(usuario, newPass);
    }

}
