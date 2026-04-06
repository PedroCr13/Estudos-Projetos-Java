package br.edu.utfpr.abastecimentosveiculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    public static final String KEY_POSTO = "KEY_POSTO";
    public static final String KEY_VEICULO = "KEY_VEICULO";
    public static final String KEY_DATAABASTECIMENTO = "KEY_DATAABASTECIMENTO";
    public static final String KEY_KMATUAL = "KEY_KMATUAL";
    public static final String KEY_COMBUSTIVEL = "KEY_COMBUSTIVEL";
    public static final String KEY_QTDLITROS = "KEY_QTDLITROS";
    public static final String KEY_VALORPAGO = "KEY_VALORPAGO";
    public static final String KEY_CALIBROUPNEU = "KEY_CALIBROUPNEU";
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

        setTitle(getString(R.string.nova_pessoa));

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
       int veiculo =  spinnerVeiculo.getSelectedItemPosition();
       int posto   = spinnerPosto.getSelectedItemPosition();

       if (veiculo == AdapterView.INVALID_POSITION){
           Toast.makeText(this,
                   R.string.o_spinner_veiculo_nao_possui_valores,
                   Toast.LENGTH_LONG).show();
           editTextDataAbastecimento.requestFocus();
           return;
       }

        if (posto == AdapterView.INVALID_POSITION){
            Toast.makeText(this,
                    R.string.o_spinner_posto_nao_possui_valores,
                    Toast.LENGTH_LONG).show();
            editTextDataAbastecimento.requestFocus();
            return;
        }

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
        Combustivel combustivel;

        if (radioButtonId == R.id.radioButtonGasolina){
            combustivel = Combustivel.Gasolina;
        } else if (radioButtonId == R.id.radioButtonEtanol) {
            combustivel = Combustivel.Etanol;
        } else {
            Toast.makeText(this,
                    R.string.selecione_o_combustivel,
                    Toast.LENGTH_LONG).show();
            return;
        }

        int qtdLitros;
        try{
            qtdLitros = Integer.parseInt(editTextQtdLitros.getText().toString());
        }catch(NumberFormatException nfe){
            Toast.makeText(this,
                    R.string.qtd_litros_invalida,
                    Toast.LENGTH_LONG).show();
            editTextQtdLitros.requestFocus();
            return;
        }

        boolean calibragemPneus;

        if (checkBoxCalibrouPneus.isChecked()){
            calibragemPneus = true;
        } else {
            calibragemPneus = false;
        }

        double valorPago;

        try{
            valorPago = Double.parseDouble(editTextValorPago.getText().toString());
        }catch(NumberFormatException nfe){
            Toast.makeText(this,
                    R.string.valor_pago_invalido,
                    Toast.LENGTH_LONG).show();
            editTextValorPago.requestFocus();
            return;
        }

        // Intent de devolução de resultados para Abastecimentos
        Intent intentResposta = new Intent();

        // Usando metodos putExtra para devolver parametros:
        // chave-valor
        intentResposta.putExtra(KEY_POSTO, posto);
        intentResposta.putExtra(KEY_VEICULO, veiculo);
        intentResposta.putExtra(KEY_DATAABASTECIMENTO, dataAbastecimento);
        intentResposta.putExtra(KEY_KMATUAL, kmAtual);
        intentResposta.putExtra(KEY_COMBUSTIVEL, combustivel.toString());
        intentResposta.putExtra(KEY_QTDLITROS, qtdLitros);
        intentResposta.putExtra(KEY_VALORPAGO, valorPago);
        intentResposta.putExtra(KEY_CALIBROUPNEU, calibragemPneus);

        setResult(MainActivity.RESULT_OK, intentResposta);

        finish();
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

