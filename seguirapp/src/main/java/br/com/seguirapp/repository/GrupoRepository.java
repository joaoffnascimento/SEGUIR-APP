package br.com.seguirapp.repository;

import br.com.seguirapp.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    void deleteByIdGrupo(int id);
   /* @Transactional
    @Modifying
    @Query(value = "DELETE FROM grupo g where g.empresa = :empresa", nativeQuery = true)
    void delete (@Param("empresa") String empresa);*/

    @Transactional
    @Modifying
    @Query(value = "UPDATE grupo g SET g.empresa =:newEmpresa WHERE g.empresa = :empresa", nativeQuery = true)
    void updateEmpresa (@Param("empresa") String empresa, @Param("newEmpresa") String newEmpresa);
}
