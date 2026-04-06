package br.edu.utfpr.abastecimentosveiculo.persistencia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.utfpr.abastecimentosveiculo.modelo.Abastecimento;

// classe Dao acessa a tabela (intermediária entre objeto e banco relacional)

@Dao
public interface AbastecimentoDao {

    // declarar as assinaturas dos metodos (retorno e saída)
    // Room se preocupa com detalhes internos
    @Insert
    long insert(Abastecimento abastecimento);

    // se der certo retorno numero > 0
    @Delete
    int delete(Abastecimento abastecimento);

    // retorno com a quantiqudade de linhas afetadas
    @Update
    int update(Abastecimento abastecimento);

    @Query("SELECT * FROM abastecimento WHERE id=:id")
    Abastecimento queryForId(Long id);

    // dastas estão salvas como string, convertido para ordenação
    @Query("SELECT * FROM abastecimento ORDER BY " +
            "substr(Data, 7, 4) || '-' || substr(Data, 4, 2) || '-' || substr(Data, 1, 2) ASC")
    List<Abastecimento> queryAllAscending();

    @Query("SELECT * FROM abastecimento ORDER BY " +
            "substr(Data, 7, 4) || '-' || substr(Data, 4, 2) || '-' || substr(Data, 1, 2) ASC")
    List<Abastecimento> queryAllDownward();
}
