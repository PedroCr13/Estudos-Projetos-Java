package com.hachathon.backend_simulador_api.sqlserver.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hachathon.backend_simulador_api.entity.sqlserver.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
	
	@Query("SELECT p FROM Produto p " +
		   "WHERE (:valor BETWEEN p.valorMinimo AND p.valorMaximo AND p.valorMaximo IS NOT NULL) " +
		   "OR (:valor >= p.valorMinimo AND p.valorMaximo IS NULL)")
	List<Produto> encontraProdutoAdequadoPorValor(@Param("valor") BigDecimal valor);
	

}
