package br.edu.utfpr.abastecimentosveiculo.persistencia;

// DAO é intermediário
// esta classe vai gerenciar o database

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.edu.utfpr.abastecimentosveiculo.modelo.Abastecimento;

@Database(entities = {Abastecimento.class}, version = 1, exportSchema = false)
public abstract class AbastecimentosDatabase extends RoomDatabase {

    public abstract AbastecimentoDao getAbastecimentoDao();

    // usando sigleton para haver apenas uma instancia do database
    private static AbastecimentosDatabase INSTANCE;

    // quando chamado abre um database existente ou cria um novo se ainda não existir instancia
    // no segundo acesso chama o banco já aberto.
    public static AbastecimentosDatabase getInstance(final Context context) {

        if (INSTANCE == null) {

            // apenas um objeto pode acessar por vez (evitar concorrência)
            synchronized (AbastecimentosDatabase.class) {

                // verificação dupla de bloqueio evitar bloqueio se mais de uma classe usar esta parte
                if (INSTANCE == null) {

                    // aplicativo simples, o acesso a bando será feito da thread principal
                    // (naõ recomendável para aplicativos profissionais, neste caso usar threads separadas

                    INSTANCE = Room.databaseBuilder(context,
                                                    AbastecimentosDatabase.class,
                                                    "abastecimentos.db").allowMainThreadQueries().build();

                }
            }
        }

        return INSTANCE;
    }

}
