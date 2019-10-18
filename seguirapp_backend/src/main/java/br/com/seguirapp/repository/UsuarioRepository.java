package br.com.seguirapp.repository;

import br.com.seguirapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario u SET u.email =:newEmail WHERE u.email = :emailAtual", nativeQuery = true)
    void updateEmail (@Param("emailAtual") String email, @Param("newEmail") String newEmail);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario u SET u.senha =:newPass WHERE u.email = :emailAtual", nativeQuery = true)
    void updatePassword (@Param("emailAtual") String email, @Param("newPass") String newPass);


}
