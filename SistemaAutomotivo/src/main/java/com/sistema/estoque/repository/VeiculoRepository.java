package com.sistema.estoque.repository;

import com.sistema.estoque.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v " +
            "WHERE (:marca IS NULL OR LOWER(v.marca) LIKE LOWER(CONCAT('%', :marca, '%'))) " +
            "AND (:modelo IS NULL OR LOWER(v.modelo) LIKE LOWER(CONCAT('%', :modelo, '%'))) " +
            "AND (:ano IS NULL OR v.ano = :ano) " +
            "AND (:status IS NULL OR LOWER(v.status) LIKE LOWER(CONCAT('%', :status, '%'))) " +
            "AND (:precoMin IS NULL OR v.preco >= :precoMin) " +
            "AND (:precoMax IS NULL OR v.preco <= :precoMax)")
    List<Veiculo> filtrar(
            @Param("marca") String marca,
            @Param("modelo") String modelo,
            @Param("ano") Integer ano,
            @Param("status") String status,
            @Param("precoMin") Double precoMin,
            @Param("precoMax") Double precoMax
    );
}
