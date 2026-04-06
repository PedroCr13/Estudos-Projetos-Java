package br.edu.utfpr.abastecimentosveiculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AbastecimentoActivity extends AppCompatActivity {
    public static final String KEY_VEICULO = "KEY_VEICULO";
    public static final String KEY_DATAABASTECIMENTO = "KEY_DATAABASTECIMENTO";
    public static final String KEY_POSTO = "KEY_POSTO";
    public static final String KEY_KMATUAL = "KEY_KMATUAL";
    public static final String KEY_COMBUSTIVEL = "KEY_COMBUSTIVEL";
    public static final String KEY_QTDLITROS = "KEY_QTDLITROS";
    public static final String KEY_VALORPAGO = "KEY_VALORPAGO";
    public static final String KEY_CALIBROUPNEU = "KEY_CALIBROUPNEU";

    // Constantes gerais
    // Irá definir qual modo a activity de caastro será aberta (cadastro ou edição)
    // será capturada na intent de abertura no onCreate
    public static final String KEY_MODO = "MODO";
    public static final int MODO_NOVO = 0;
    public static final int MODO_EDITAR = 1;

    private Spinner spinnerVeiculo;
    private Spinner spinnerPosto;
    private EditText editTextDataAbastecimento;
    private EditText editTextKmAtual;
    private RadioGroup radioGroupCombustivel;
    private EditText editTextQtdLitros;
    private EditText editTextValorPago;
    private CheckBox checkBoxCalibrouPneus;
    private RadioButton radioButtonGasolina;
    private RadioButton radioButtonEtanol;

    private int modo;
    private Abastecimento abastecimentoOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

        editTextDataAbastecimento = findViewById(R.id.editTextDataAbastecimento);
        spinnerVeiculo = findViewById(R.id.spinnerVeiculo);
        spinnerPosto = findViewById(R.id.spinnerPosto);
        editTextKmAtual = findViewById(R.id.editTextNumberDecimalKmAtual);
        radioGroupCombustivel = findViewById(R.id.radioGroupCombustivel);
        editTextQtdLitros = findViewById(R.id.editTextNumberQtdLitros);
        editTextValorPago = findViewById(R.id.editTextNumberDecimalValorTotalPago);
        checkBoxCalibrouPneus = findViewById(R.id.checkBoxCalibrouPeneus);
        radioButtonGasolina = findViewById(R.id.radioButtonGasolina);
        radioButtonEtanol = findViewById(R.id.radioButtonEtanol);

        popularSpinnerVeiculos();

        // obtem a intent que foi usada para abrir
        Intent intentAbertura = getIntent();

        // busca parâmetros na intent que chamou:
        Bundle bundle = intentAbertura.getExtras();

        // testa se veio parâmetros
        if (bundle != null)
        {
            modo = bundle.getInt(KEY_MODO);

            if (modo == MODO_NOVO) {
                setTitle(getString(R.string.novo_abastecimento));
                editTextDataAbastecimento.setText(obterDataAtual());
            } else {
                setTitle(getString(R.string.editar_abastecimento));

                // Extrair dos dados que vieram na intent e atribuir aos fields:
                String dataAbastecimento = bundle.getString(AbastecimentoActivity.KEY_DATAABASTECIMENTO);
                int veiculo = bundle.getInt(AbastecimentoActivity.KEY_VEICULO);
                int posto = bundle.getInt(AbastecimentoActivity.KEY_POSTO);
                double kmAtual = bundle.getDouble(AbastecimentoActivity.KEY_KMATUAL);
                String combustivelTexto = bundle.getString(AbastecimentoActivity.KEY_COMBUSTIVEL);
                int qtdLitros = bundle.getInt(AbastecimentoActivity.KEY_QTDLITROS);
                double valorPago = bundle.getDouble(AbastecimentoActivity.KEY_VALORPAGO);
                boolean calibrouPneu = bundle.getBoolean(AbastecimentoActivity.KEY_CALIBROUPNEU);

                // nome do enum deve ser usado apenas no código fonte, não na interface:
                Combustivel combustivel = Combustivel.valueOf(combustivelTexto);

                abastecimentoOriginal = new Abastecimento(dataAbastecimento, veiculo, posto, kmAtual, combustivel,
                        qtdLitros, valorPago, calibrouPneu);

                // setando valoers recuperados nos campos:
                editTextDataAbastecimento.setText(dataAbastecimento);
                spinnerVeiculo.setSelection(veiculo);
                spinnerPosto.setSelection(posto);
                editTextKmAtual.setText(String.valueOf(kmAtual));

                if (combustivel == Combustivel.Gasolina) {
                    radioButtonGasolina.setChecked(true);
                } else
                    if (combustivel == Combustivel.Etanol) {
                        radioButtonEtanol.setChecked(true);
                    }

                editTextQtdLitros.setText(String.valueOf(qtdLitros));
                editTextValorPago.setText(String.valueOf(valorPago));
                checkBoxCalibrouPneus.setChecked(calibrouPneu);
            }
        }

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
    public void salvarAbastecimento(){
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

        // Antes de salvar editando verifica se realmente houve alteração
        if (modo == MODO_EDITAR &&
            dataAbastecimento.equals(abastecimentoOriginal.getData()) &&
            posto == abastecimentoOriginal.getPosto()     &&
            veiculo == abastecimentoOriginal.getVeiculo() &&
            kmAtual == abastecimentoOriginal.getKmAtual() &&
            combustivel == abastecimentoOriginal.getCombustivel() &&
            qtdLitros == abastecimentoOriginal.getQtdLitros() &&
            valorPago == abastecimentoOriginal.getValorPago() &&
            calibragemPneus == abastecimentoOriginal.isCalibrouPneus()) {

            // retonar sem alterar nada
            setResult(AbastecimentoActivity.RESULT_CANCELED);
            finish();
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

        setResult(AbastecimentoActivity.RESULT_OK, intentResposta);

        finish();
    }

    public void limparCampos(){
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

    // Metodos para inflar Menu e tratar eventos:

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.abastecimento_opcoes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idMenuItem = item.getItemId();

        if (idMenuItem == R.id.menuItemSalvar)
        {
            salvarAbastecimento();
            return true;
        } else
            if (idMenuItem == R.id.menuItemLimpar) {
                limparCampos();
                return true;
            } else {
                // tratador do pai se não for nenhuma das duas opções
                return super.onOptionsItemSelected(item);
            }
    }
}

