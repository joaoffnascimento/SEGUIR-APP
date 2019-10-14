package br.com.seguirapp.repository;

import br.com.seguirapp.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE veiculo v SET v.placa =:newPlaca WHERE v.placa = :placa", nativeQuery = true)
    Veiculo updatePlaca (@Param("placa") String placa, @Param("newPlaca") String newPlaca);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cor a SET a.cor =:newCor WHERE a.cor = :cor", nativeQuery = true)
    Veiculo updateCor (@Param("cor") String cor, @Param("newCor") String newCor);
}
