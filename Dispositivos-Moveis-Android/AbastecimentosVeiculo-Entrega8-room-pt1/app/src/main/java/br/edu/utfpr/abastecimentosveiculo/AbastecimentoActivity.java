package br.edu.utfpr.abastecimentosveiculo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import br.edu.utfpr.abastecimentosveiculo.modelo.Abastecimento;
import br.edu.utfpr.abastecimentosveiculo.modelo.Combustivel;
import br.edu.utfpr.abastecimentosveiculo.utils.UtilsAlert;

public class AbastecimentoActivity extends AppCompatActivity {
    public static final String KEY_VEICULO = "KEY_VEICULO";
    public static final String KEY_DATAABASTECIMENTO = "KEY_DATAABASTECIMENTO";
    public static final String KEY_POSTO = "KEY_POSTO";
    public static final String KEY_KMATUAL = "KEY_KMATUAL";
    public static final String KEY_COMBUSTIVEL = "KEY_COMBUSTIVEL";
    public static final String KEY_QTDLITROS = "KEY_QTDLITROS";
    public static final String KEY_VALORPAGO = "KEY_VALORPAGO";
    public static final String KEY_CALIBROUPNEU = "KEY_CALIBROUPNEU";

    // Shared Preferences:
    public static final String KEY_SUGERIR_VEICULO = "SUGERIR_VEICULO";
    public static final String KEY_ULTIMO_VEICULO = "ULTIMO_VEICULO";
    public static final String KEY_SUGERIR_POSTO = "SUGERIR_POSTO";
    public static final String KEY_ULTIMO_POSTO = "ULTIMO_POSTO";

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

    // atributos sugestao Shared Preerences
    private boolean sugerirVeiculo = false;
    private int ultimoVeiculo = 0;
    private boolean sugerirPosto = false;
    private int ultimoPosto = 0;

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

        lerPreferences();

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

                if (sugerirVeiculo) {
                    spinnerVeiculo.setSelection(ultimoVeiculo);
                }

                if (sugerirPosto) {
                    spinnerPosto.setSelection(ultimoPosto);
                }

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
           UtilsAlert.mostrarAviso(this, R.string.o_spinner_veiculo_nao_possui_valores);

           editTextDataAbastecimento.requestFocus();
           return;
       }

        if (posto == AdapterView.INVALID_POSITION){
            UtilsAlert.mostrarAviso(this, R.string.o_spinner_posto_nao_possui_valores);

            editTextDataAbastecimento.requestFocus();
            return;
        }

        String dataAbastecimento = editTextDataAbastecimento.getText().toString();

        if (dataAbastecimento == null || dataAbastecimento.trim().isEmpty()){
            UtilsAlert.mostrarAviso(this, R.string.preencha_data_do_abastecimento);

            editTextDataAbastecimento.requestFocus();
            return;
        }

        double kmAtual;
        try {
             kmAtual = Double.parseDouble(editTextKmAtual.getText().toString());
        } catch(NumberFormatException nfe){
            UtilsAlert.mostrarAviso(this, R.string.km_atual_invalida);
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
            UtilsAlert.mostrarAviso(this, R.string.selecione_o_combustivel);

            return;
        }

        int qtdLitros;
        try{
            qtdLitros = Integer.parseInt(editTextQtdLitros.getText().toString());
        }catch(NumberFormatException nfe){
            UtilsAlert.mostrarAviso(this, R.string.qtd_litros_invalida);

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
            UtilsAlert.mostrarAviso(this, R.string.valor_pago_invalido);

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

            // retornar sem alterar nada
            setResult(AbastecimentoActivity.RESULT_CANCELED);
            finish();
            return;
        }

        salvarUtimoVeiculo(veiculo);
        salvarUltimoPosto(posto);

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

        // captura campos preenchidos para usuário desfazer
        final String data = editTextDataAbastecimento.getText().toString();
        final int veiculo = spinnerVeiculo.getSelectedItemPosition();
        final int posto   = spinnerPosto.getSelectedItemPosition();
        final String kmAtual = editTextKmAtual.getText().toString();
        final int combustivel = radioGroupCombustivel.getCheckedRadioButtonId();
        final String qtdLitros = editTextQtdLitros.getText().toString();
        final String valorPago = editTextValorPago.getText().toString();
        final boolean calibrouPneu = checkBoxCalibrouPneus.isChecked();

        final ScrollView scrollView = findViewById(R.id.main);
        final View viewComFoco      = scrollView.findFocus();

        spinnerVeiculo.setSelection(0);
        spinnerPosto.setSelection(0);
        editTextDataAbastecimento.setText(null);
        editTextKmAtual.setText(null);
        radioGroupCombustivel.clearCheck();
        editTextQtdLitros.setText(null);
        editTextValorPago.setText(null);
        checkBoxCalibrouPneus.setChecked(false);
        editTextDataAbastecimento.requestFocus();

        Snackbar snackBar = Snackbar.make(scrollView,
                                     getString(R.string.os_campos_foram_limpos),
                                     Snackbar.LENGTH_LONG);

        snackBar.setAction(getString(R.string.desfazer), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // preenche com os valores anteriores:
                spinnerVeiculo.setSelection(veiculo);
                spinnerPosto.setSelection(posto);
                editTextDataAbastecimento.setText(data);
                editTextKmAtual.setText(kmAtual);

                if (combustivel == R.id.radioButtonGasolina){
                    radioButtonGasolina.setChecked(true);
                } else
                    if (combustivel == R.id.radioButtonEtanol) {
                        radioButtonEtanol.setChecked(true);
                    }

                editTextQtdLitros.setText(qtdLitros);
                editTextValorPago.setText(valorPago);
                checkBoxCalibrouPneus.setChecked(calibrouPneu);

                if (viewComFoco != null)
                {
                    viewComFoco.requestFocus();
                }
            }
        });

        snackBar.show();
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

    // toda vez que for exibir o menu onPrepare é chamado
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // checkbox sugerir marcado ou não
        MenuItem itemSugerirVeiculo = menu.findItem(R.id.menuItemSugerirVeiculo);
        itemSugerirVeiculo.setChecked(sugerirVeiculo);

        MenuItem itemSugerirPosto = menu.findItem(R.id.menuItemSugerirPosto);
        itemSugerirPosto.setChecked(sugerirPosto);

        // true para menu ser exibido
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
            } else
                if (idMenuItem == R.id.menuItemSugerirVeiculo) {

                    // usuario clicou inverte selecao
                    boolean valorSugerirVeiculo = !item.isChecked();

                    salvarSugerirVeiculo(valorSugerirVeiculo);
                    item.setChecked(valorSugerirVeiculo);

                    if (sugerirVeiculo) {
                        spinnerVeiculo.setSelection(ultimoVeiculo);
                    }

                    return true;
                }
                else
                    if (idMenuItem == R.id.menuItemSugerirPosto) {
                        boolean valorSugrirPosto = !item.isChecked();

                        salvarSugerirPosto(valorSugrirPosto);
                        item.setChecked(valorSugrirPosto);

                        if (sugerirPosto) {
                            spinnerPosto.setSelection(ultimoPosto);
                        }

                        return true;
                    }
                else {
                    // tratador do pai se não for nenhuma das duas opções
                    return super.onOptionsItemSelected(item);
                }
    }

    // arquivo shared preferences
    // criar arquivo primeira vez
    private void lerPreferences() {
        // modo exclusivo
        SharedPreferences shared = getSharedPreferences(AbastecimentosActivity.ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        sugerirVeiculo = shared.getBoolean(KEY_SUGERIR_VEICULO, sugerirVeiculo);
        ultimoVeiculo  = shared.getInt(KEY_ULTIMO_VEICULO, ultimoVeiculo);

        sugerirPosto = shared.getBoolean(KEY_SUGERIR_POSTO, sugerirPosto);
        ultimoPosto = shared.getInt(KEY_ULTIMO_POSTO, ultimoPosto);
    }

    private void salvarSugerirVeiculo(boolean novoValor){
        SharedPreferences shared = getSharedPreferences(AbastecimentosActivity.ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putBoolean(KEY_SUGERIR_VEICULO, novoValor);

        editor.commit();

        sugerirVeiculo = novoValor;
    }

    private void salvarSugerirPosto(boolean novoValor){
        SharedPreferences shared = getSharedPreferences(AbastecimentosActivity.ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putBoolean(KEY_SUGERIR_POSTO, novoValor);

        editor.commit();

        sugerirPosto = novoValor;
    }

    private void salvarUtimoVeiculo(int novoValor) {
        SharedPreferences shared = getSharedPreferences(AbastecimentosActivity.ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putInt(KEY_ULTIMO_VEICULO, novoValor);

        editor.commit();

        ultimoVeiculo = novoValor;
    }

    private void salvarUltimoPosto(int novoValor) {
        SharedPreferences shared = getSharedPreferences(AbastecimentosActivity.ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putInt(KEY_ULTIMO_POSTO, novoValor);

        editor.commit();

        ultimoPosto = novoValor;
    }
}

