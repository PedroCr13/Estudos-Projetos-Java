package com.hachathon.backend_simulador_api.h2.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hachathon.backend_simulador_api.entity.h2.Simulacao;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long>{

	@Query(value = "SELECT S.DATA_SIMULACAO, S.ID_PRODUTO, S.NOME_PRODUTO, AVG(S.TAXA) AS TAXA_MEDIA, " +
		    "SUM(S.VR_DESEJADO) AS VALOR_TOTAL_DESEJADO, " +
		    "AVG((SELECT P.VALOR_PRESTACAO FROM RESULTADO_SIMULACAO R " +
		        "INNER JOIN PARCELA P ON P.ID_RESULTADO_SIMULACAO = R.ID " +
		        "WHERE R.ID_SIMULACAO = S.ID AND R.TIPO = 'SAC' AND P.NUM_PARCELA = 1 " +
		    ")) AS VALOR_PRIMEIRA_SAC, " +
		    "AVG(( SELECT P.VALOR_PRESTACAO FROM RESULTADO_SIMULACAO R " +
		        "INNER JOIN PARCELA P ON P.ID_RESULTADO_SIMULACAO = R.ID " +
		        "WHERE R.ID_SIMULACAO = S.ID AND R.TIPO = 'PRICE' AND P.NUM_PARCELA = 1 " +
		    ")) AS VALOR_PRIMEIRA_PRICE, " +
		    "SUM(( SELECT SUM(P.VALOR_PRESTACAO) FROM RESULTADO_SIMULACAO R " +
		    	"INNER JOIN PARCELA P ON P.ID_RESULTADO_SIMULACAO = R.ID " +
		        "WHERE R.ID_SIMULACAO = S.ID AND R.TIPO = 'SAC' " +
		    ")) AS TOTAL_PARCELAS_SAC, " +
		    "SUM(( SELECT SUM(P.VALOR_PRESTACAO) FROM RESULTADO_SIMULACAO R " +
		        "INNER JOIN PARCELA P ON P.ID_RESULTADO_SIMULACAO = R.ID " +
		        "WHERE R.ID_SIMULACAO = S.ID AND R.TIPO = 'PRICE' " +
		    ")) AS TOTAL_PARCELAS_PRICE " +
		"FROM SIMULACAO S " +
		"GROUP BY S.DATA_SIMULACAO, S.NOME_PRODUTO " +
		"ORDER BY S.DATA_SIMULACAO ASC", nativeQuery = true)
	List<Object[]> listarSimulacoesDataAgrupadasPorData();
	//retorna um list de objetos (super classe do java, native query não permite mapeamento direto no DTO
}
