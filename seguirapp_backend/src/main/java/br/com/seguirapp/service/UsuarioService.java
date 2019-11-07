package br.com.seguirapp.service;

import br.com.seguirapp.model.Usuario;
import br.com.seguirapp.repository.UsuarioRepository;
import br.com.seguirapp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioDAO;

    private static UsuarioService myInstance;

    public synchronized static UsuarioService getInstance() {
        if (myInstance == null) {
            myInstance = new UsuarioService();
        }
        return myInstance;
    }

    private Util util = new Util();

    // Politica de criacao de senha
    public Usuario createUser(String email, String senha) throws Exception {
        if (!util.isEmail(email)) {
            throw new Exception("E-mail invalido");
        }

        if (usuarioDAO.findByEmail(email) != null) {
            throw new Exception("E-mail já cadastrado!");
        }

        if (senha.length() < 4) {
            throw new Exception("Senha deve possui mais que 4 caracteres");
        }

        Usuario user = new Usuario(email, senha);
        return usuarioDAO.save(user);
    }

    public void updateEmail(Usuario usuario, String newEmail) throws Exception {
        if (!Util.isEmail(newEmail))
            throw new Exception("E-mail Inválido!!!");
        if (usuarioDAO.findByEmail(usuario.getEmail()) == null)
            throw new Exception("Usuário Não Encontrado!!!");
        usuarioDAO.updateEmail(usuario.getEmail(), newEmail);
    }

    public void updateSenha(Usuario user, String newSenha) throws Exception {
        if ((usuarioDAO.findByEmail(user.getEmail())) == null)
            throw new Exception("Usuário Não Encontrado!!!");
        user.setSenha(newSenha);
        usuarioDAO.updatePassword(user.getEmail(), newSenha);
    }

    public Usuario findByEmail(String email){
        return usuarioDAO.findByEmail(email);
    }

    public void deleteUser(String email){
        usuarioDAO.deleteById(email);
    }

}
