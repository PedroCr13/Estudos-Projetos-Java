package br.edu.utfpr.abastecimentosveiculo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerVeiculo;
    private Spinner spinnerPosto;
    private EditText editTextDataAbastecimento;
    private EditText editTextKmAtual;
    private RadioGroup radioGroupCombustivel;
    private EditText editTextQtdLitros;
    private EditText editTextValorPago;
    private CheckBox checkBoxCalibrouPneus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerVeiculo = findViewById(R.id.spinnerVeiculo);
        spinnerPosto = findViewById(R.id.spinnerPosto);
        editTextDataAbastecimento = findViewById(R.id.editTextDataAbastecimento);
        editTextKmAtual = findViewById(R.id.editTextNumberDecimalKmAtual);
        radioGroupCombustivel = findViewById(R.id.radioGroupCombustivel);
        editTextQtdLitros = findViewById(R.id.editTextNumberQtdLitros);
        editTextValorPago = findViewById(R.id.editTextNumberDecimalValorTotalPago);
        checkBoxCalibrouPneus = findViewById(R.id.checkBoxCalibrouPeneus);

        popularSpinnerVeiculos();

        editTextDataAbastecimento.setText(obterDataAtual());

        editTextDataAbastecimento.requestFocus();
    }
    private void popularSpinnerVeiculos(){
        ArrayList<String> listaVeiculos = new ArrayList<>();

        listaVeiculos.add(getString(R.string.Gol));
        listaVeiculos.add(getString(R.string.Uno));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                                        android.R.layout.simple_list_item_1, listaVeiculos);

        spinnerVeiculo.setAdapter(adapter);
    }
    public void salvarAbastecimento(View view){
        String veiculo = (String) spinnerVeiculo.getSelectedItem();
        String posto = (String) spinnerPosto.getSelectedItem();

        String dataAbastecimento = editTextDataAbastecimento.getText().toString();

        if (dataAbastecimento == null || dataAbastecimento.trim().isEmpty()){
            Toast.makeText(this,
                    R.string.preencha_data_do_abastecimento,
                    Toast.LENGTH_LONG).show();
            editTextDataAbastecimento.requestFocus();
            return;
        }

        double kmAtual;
        try {
             kmAtual = Double.parseDouble(editTextKmAtual.getText().toString());
        } catch(NumberFormatException nfe){
            Toast.makeText(this,
                    R.string.km_atual_invalida,
                    Toast.LENGTH_LONG).show();
            editTextKmAtual.requestFocus();
            return;
        }

        int radioButtonId = radioGroupCombustivel.getCheckedRadioButtonId();
        String combustivel;

        if (radioButtonId == R.id.radioButtonGasolina){
            combustivel = getString(R.string.opcao_gasolina);
        } else if (radioButtonId == R.id.radioButtonEtanol) {
            combustivel = getString(R.string.opcao_etanol);
        } else {
            Toast.makeText(this,
                    R.string.selecione_o_combustivel,
                    Toast.LENGTH_LONG).show();
            return;
        }

        double qtdLitros;
        try{
            qtdLitros = Integer.parseInt(editTextQtdLitros.getText().toString());
        }catch(NumberFormatException nfe){
            Toast.makeText(this,
                    R.string.qtd_litros_invalida,
                    Toast.LENGTH_LONG).show();
            editTextQtdLitros.requestFocus();
            return;
        }

        String calibragemPneus;

        if (checkBoxCalibrouPneus.isChecked()){
            calibragemPneus = getString(R.string.penus_calibrados);
        } else {
            calibragemPneus = getString(R.string.pneus_nao_calibrados);
        }

        double valorPago;

        try{
            valorPago = Double.parseDouble(editTextValorPago.getText().toString());
        }catch(NumberFormatException nfe){
            Toast.makeText(this,
                    "Valor pago inválido!",
                    Toast.LENGTH_LONG).show();
            editTextValorPago.requestFocus();
            return;
        }

        Toast.makeText(this,
                getString(R.string.nome_posto) + posto + "\n" +
                getString(R.string.selecione_veiculo) + veiculo + "\n" +
                getString(R.string.data_abastecimento) + dataAbastecimento + "\n" +
                getString(R.string.km_atual) + kmAtual + "\n" +
                getString(R.string.combustivel) + combustivel +"\n" +
                getString(R.string.quantidade_litros) + qtdLitros + "\n" +
                getString(R.string.valor_total_pago) + valorPago + "\n" +
                getString(R.string.calibrado_pneus) + calibragemPneus,
                Toast.LENGTH_LONG).show();
    }
    public void limparCampos(View view){
        spinnerVeiculo.setSelection(0);
        spinnerPosto.setSelection(0);
        editTextDataAbastecimento.setText(null);
        editTextKmAtual.setText(null);
        radioGroupCombustivel.clearCheck();
        editTextQtdLitros.setText(null);
        editTextValorPago.setText(null);
        checkBoxCalibrouPneus.setChecked(false);

        editTextDataAbastecimento.requestFocus();

        Toast.makeText(this,
                       R.string.os_campos_foram_limpos,
                        Toast.LENGTH_LONG).show();
    }

    private String obterDataAtual(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return d.format(c.getTime());
    }
}