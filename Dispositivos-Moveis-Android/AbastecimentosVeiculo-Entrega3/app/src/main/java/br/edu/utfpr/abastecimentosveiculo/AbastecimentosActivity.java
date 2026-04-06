package br.edu.utfpr.abastecimentosveiculo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

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

        setTitle(getString(R.string.controle_dos_abastecimentos));

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
       /*
        não será usado mais
        String[] abastecimentosData      = getResources().getStringArray(R.array.abastecimento_data);
        int[] abastecimentosVeiculo      = getResources().getIntArray(R.array.abastecimento_veiculo);
        int[] abastecimentosPosto        = getResources().getIntArray(R.array.abastecimento_postos);
        int[] abastecimentosKmAtual      = getResources().getIntArray(R.array.abastecimento_kmatual);
        int[] abastecimentosCombustivel  = getResources().getIntArray(R.array.abastecimento_combustivel);
        int[] abastecimentosQtdLitro     = getResources().getIntArray(R.array.abastecimento_qtdLitros);
        int[] abastecimentosValorPago    = getResources().getIntArray(R.array.abastecimento_valorpago);
        int[] abastecimentosCalibrouPneu = getResources().getIntArray(R.array.abastecimento_calibrou_pneus);
      */

        listaAbastecimentos = new ArrayList<>();

        Abastecimento abastecimento;
        boolean pneuCalibrados;
        Combustivel combustivel;

        Combustivel[] combustiveis = Combustivel.values();

        /*
        não será utilizado mais
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
        */

        abastecimentoAdapter = new AbastecimentoAdapter(this, listaAbastecimentos);

        listViewAbastecimentos.setAdapter(abastecimentoAdapter);
    }

    public void abrirSobre(View view)
    {
        // Intent explicita (indica para onde quer ir)
        Intent intentAbertura = new Intent(this, SobreActivity.class);

        startActivity(intentAbertura);
    }

    ActivityResultLauncher<Intent> launcherNovoAbastecimento = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == AbastecimentosActivity.RESULT_OK)
                    {
                        // quem vai receber os dados
                        Intent intent = result.getData();

                        // quem irá devolver
                        Bundle bundle = intent.getExtras();

                        if (bundle != null)
                        {
                            int posto = bundle.getInt(MainActivity.KEY_POSTO);
                            int veiculo = bundle.getInt(MainActivity.KEY_VEICULO);
                            String dataAbastecimento = bundle.getString(MainActivity.KEY_DATAABASTECIMENTO);
                            double kmAtual = bundle.getDouble(MainActivity.KEY_KMATUAL);
                            String combustivelTexto = bundle.getString(MainActivity.KEY_COMBUSTIVEL);
                            int qtdLitros = bundle.getInt(MainActivity.KEY_QTDLITROS);
                            double valorPago = bundle.getDouble(MainActivity.KEY_VALORPAGO);
                            boolean calibrouPneu = bundle.getBoolean(MainActivity.KEY_CALIBROUPNEU);

                            Abastecimento abastecimento = new Abastecimento(dataAbastecimento, veiculo, posto, kmAtual,
                                    Combustivel.valueOf(combustivelTexto), qtdLitros, valorPago, calibrouPneu);

                            listaAbastecimentos.add(abastecimento);

                            // Avisa que houve alterações, será renderizado novamente
                            abastecimentoAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });

    public void abrirNovoAbastecimento(View view)
    {
        Intent intentAbertura = new Intent(this, MainActivity.class);
        launcherNovoAbastecimento.launch(intentAbertura);
    }
}