package br.com.seguirapp.repository;

import br.com.seguirapp.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

    @Transactional
    @Modifying
    @Query(value = "select * from localizacao l where l.dispositivo =:dispositivo", nativeQuery = true)
    List<String> getLocalizacao (@Param("dispositivo") int dispositivo);
}
