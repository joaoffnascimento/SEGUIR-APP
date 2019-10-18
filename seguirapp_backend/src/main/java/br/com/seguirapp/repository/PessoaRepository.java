package br.com.seguirapp.repository;

import br.com.seguirapp.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


    @Transactional
    @Modifying
    @Query(value = "select p.nome from pessoa p join grupo g where (p.id_grupo =:idGrupo = g.id_grupo =:idGrupo)", nativeQuery = true)
    List<String> getDependentes(@Param("idGrupo") int idGrupo);

}
