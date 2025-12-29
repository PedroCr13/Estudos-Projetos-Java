package br.com.pclf.simuladorsalarial;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //mapeamento dos componentes:
    private EditText editTextSalarioBase;
    private EditText editTextSalarioBruto;
    private CheckBox checkBoxPlanoDeSaude;
    private CheckBox checkBoxSindicato;
    private CheckBox checkBoxAssociacao;
    private CheckBox checkBoxValeTransporte;
    private EditText editTextQtdDependentesIR;
    private Spinner spinnerContribuicaoPrev;
    private EditText editTextSalarioLiquido;
    private TextView textViewResultadoINSS;
    private TextView textViewResultaudoIR;
    private TextView textViewResultadoPrevidencia;
    private TextView textViewResultadoPlanoSaude;
    private TextView textViewResultadoSindicato;
    private TextView textViewResultadoAssociacao;
    private TextView textViewResultadoValeTransporte;
    private TextView textviewResultadoBaseIR;
    private TextView textViewValorFGTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSalarioBase = findViewById(R.id.editTextNumberDecimalSalarioBase);
        editTextSalarioBruto = findViewById(R.id.editTextNumberDecimalSalarioBruto);
        checkBoxPlanoDeSaude = findViewById(R.id.checkBoxPlanoSaude);
        checkBoxSindicato = findViewById(R.id.checkBoxSindicato);
        checkBoxAssociacao = findViewById(R.id.checkBoxAssociacao);
        checkBoxValeTransporte = findViewById(R.id.checkBoxValeTransporte);
        editTextQtdDependentesIR = findViewById(R.id.editTextNumberQtdDependentesIR);
        spinnerContribuicaoPrev = findViewById(R.id.spinnerContribuicaoPrev);
        editTextSalarioLiquido = findViewById(R.id.editTextTextSalarioLiquido);

        textViewResultadoINSS = findViewById(R.id.textViewResultadoINSS);
        textViewResultadoPrevidencia = findViewById(R.id.textViewResultadoPrevidencia);
        textViewResultaudoIR = findViewById(R.id.textViewResultadoIR);
        textViewResultadoPlanoSaude = findViewById(R.id.textViewResultadoPlanoDeSaude);
        textViewResultadoSindicato = findViewById(R.id.textViewResultadoSindicato);
        textViewResultadoAssociacao = findViewById(R.id.textViewResultadoMesalidadeAssociacao);
        textViewResultadoValeTransporte = findViewById(R.id.textViewResultadoVT);
        textviewResultadoBaseIR = findViewById(R.id.textViewResultadoBaseIR);
        textViewValorFGTS = findViewById(R.id.textViewResultadoFGTS);
        editTextSalarioLiquido.setEnabled(false);

        editTextQtdDependentesIR.setText("0");

        editTextSalarioBase.requestFocus();
    }

    public void calcularSalario(View view){

        double salarioBase = 0, salarioBruto = 0;
        int qtdDependentesIR = 0, contribuicaoPrevidencia = 0;

        try {
            salarioBase = Double.parseDouble(editTextSalarioBase.getText().toString());
        } catch (NumberFormatException nfe){
            Toast.makeText(this,
                    getString(R.string.salario_base_invalido) + nfe.getMessage() + "]",
                    Toast.LENGTH_LONG).show();
            editTextSalarioBase.requestFocus();
            return;
        }

        if (editTextSalarioBruto == null || editTextSalarioBruto.getText().toString().trim().isEmpty()){
            salarioBruto = salarioBase;
        } else {
            try {
                salarioBruto = Double.parseDouble(editTextSalarioBruto.getText().toString());
            } catch (NumberFormatException nfe){
                Toast.makeText(this,
                        getString(R.string.salario_bruto_invalido) + nfe.getMessage() + "]",
                        Toast.LENGTH_LONG).show();
                editTextSalarioBruto.requestFocus();
                return;
            }
        }

        try {
            qtdDependentesIR = Integer.parseInt(editTextQtdDependentesIR.getText().toString());
        } catch (NumberFormatException nfe){
            Toast.makeText(this,
                    getString(R.string.quantidade_de_dependentes_invalida) + nfe.getMessage() + "]",
                    Toast.LENGTH_LONG).show();
            editTextQtdDependentesIR.requestFocus();
            return;
        }

        try {

            String tipo = (String) spinnerContribuicaoPrev.getSelectedItem();

            contribuicaoPrevidencia = Integer.parseInt(tipo);
        } catch (NumberFormatException nfe){
            Toast.makeText(this,
                    getString(R.string.contribuicao_previdencia_invalida) + nfe.getMessage() + "]",
                    Toast.LENGTH_LONG).show();
            spinnerContribuicaoPrev.requestFocus();
            return;
        }

        Salario salario = new Salario();
        salario.setSalarioBase(salarioBase);
        salario.setSalarioBruto(salarioBruto);
        salario.setValorINSS();
        salario.setPercContPrev(contribuicaoPrevidencia);
        salario.setValorPrevidencia();
        salario.setQuantidadeDependentes(qtdDependentesIR);
        salario.setValorImpostoRenda();
        salario.setValorFGTS();

        if (checkBoxPlanoDeSaude.isChecked()){
            salario.setValorPlanoSaude();
        }

        if (checkBoxValeTransporte.isChecked()){
            salario.setValorValeTransporte();
        }

        if (checkBoxAssociacao.isChecked()){
            salario.setValorAssociacao();
        }

        if (checkBoxSindicato.isChecked()){
            salario.setValorSindicato();
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        editTextSalarioLiquido.setText(nf.format(salario.salarioLiquido()));

        textViewResultadoINSS.setText("Contribuição INSS: " + nf.format(salario.getValorINSS()));
        textViewResultadoPrevidencia.setText("Contribuição Previdência: " + nf.format(salario.getValorPrevidencia()));
        textViewResultaudoIR.setText("Imposto de Renda: " + nf.format(salario.getValorImpostoRenda()));
        textViewResultadoPlanoSaude.setText("Mensalidade Plano de Saúde: " + nf.format(salario.getValorPlanoSaude()));
        textViewResultadoSindicato.setText("Mensalidade Sindicato: " + nf.format(salario.getValorSindicato()));
        textViewResultadoAssociacao.setText("Mensalidade Associação " + nf.format(salario.getValorAssociacao()));
        textViewResultadoValeTransporte.setText("Desconto Vale Transporte: " + nf.format(salario.getValorValeTransporte()));
        textviewResultadoBaseIR.setText("Base de Cálculo IR: " + nf.format(salario.getBaseCalculoIR()));
        textViewValorFGTS.setText("FGTS do mês: " + nf.format(salario.getValorFGTS()));
    }

    public void limparCampos(View view){
        editTextSalarioBase.setText(null);
        editTextSalarioBruto.setText(null);
        checkBoxPlanoDeSaude.setChecked(false);
        checkBoxSindicato.setChecked(false);
        checkBoxAssociacao.setChecked(false);
        checkBoxValeTransporte.setChecked(false);
        editTextQtdDependentesIR.setText("0");
        spinnerContribuicaoPrev.setSelection(0);
        editTextSalarioLiquido.setText(null);

        textViewResultadoINSS.setText("");
        textViewResultaudoIR.setText("");
        textViewResultadoPrevidencia.setText("");
        textViewResultadoPlanoSaude.setText("");
        textViewResultadoSindicato.setText("");
        textViewResultadoAssociacao.setText("");
        textViewResultadoValeTransporte.setText("");
        textviewResultadoBaseIR.setText("");
        textViewValorFGTS.setText("");

        editTextSalarioBase.requestFocus();

        Toast.makeText(this,
                     "Os campos foram apagados!",
                      Toast.LENGTH_LONG).show();
    }
}