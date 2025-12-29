package br.edu.utfpr.abastecimentosveiculo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AbastecimentosActivity extends AppCompatActivity {

    private List<Abastecimento> listaAbastecimentos;
    private ListView listViewAbastecimentos;

    private AbastecimentoAdapter abastecimentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimentos);

        listViewAbastecimentos = findViewById(R.id.listViewAbastecimentos);

        listViewAbastecimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                Abastecimento abastecimento = (Abastecimento) listViewAbastecimentos.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),
                        getString(R.string.abastecimento_realizado_em) + abastecimento.getData() + getString(R.string.foi_clicado),
                Toast.LENGTH_LONG).show();
            }
        });

        popularListaAbastecimentos();
    }

    private void popularListaAbastecimentos(){
        String[] abastecimentosData      = getResources().getStringArray(R.array.abastecimento_data);
        int[] abastecimentosVeiculo      = getResources().getIntArray(R.array.abastecimento_veiculo);
        int[] abastecimentosPosto        = getResources().getIntArray(R.array.abastecimento_postos);
        int[] abastecimentosKmAtual      = getResources().getIntArray(R.array.abastecimento_kmatual);
        int[] abastecimentosCombustivel  = getResources().getIntArray(R.array.abastecimento_combustivel);
        int[] abastecimentosQtdLitro     = getResources().getIntArray(R.array.abastecimento_qtdLitros);
        int[] abastecimentosValorPago    = getResources().getIntArray(R.array.abastecimento_valorpago);
        int[] abastecimentosCalibrouPneu = getResources().getIntArray(R.array.abastecimento_calibrou_pneus);

        listaAbastecimentos = new ArrayList<>();

        Abastecimento abastecimento;
        boolean pneuCalibrados;
        Combustivel combustivel;

        Combustivel[] combustiveis = Combustivel.values();

        for(int cont = 0; cont < abastecimentosData.length; cont++){

            pneuCalibrados = (abastecimentosCalibrouPneu[cont] == 1 ? true:false);

            combustivel = combustiveis[abastecimentosCombustivel[cont]];

            abastecimento = new Abastecimento(
                    abastecimentosData[cont],
                    abastecimentosVeiculo[cont],
                    abastecimentosPosto[cont],
                    abastecimentosKmAtual[cont],
                    combustivel,
                    abastecimentosQtdLitro[cont],
                    abastecimentosValorPago[cont],
                    pneuCalibrados
            );

            listaAbastecimentos.add(abastecimento);
        }

        abastecimentoAdapter = new AbastecimentoAdapter(this, listaAbastecimentos);

        listViewAbastecimentos.setAdapter(abastecimentoAdapter);
    }
}