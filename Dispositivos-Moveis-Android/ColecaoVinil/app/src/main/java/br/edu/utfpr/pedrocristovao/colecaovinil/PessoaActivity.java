package br.edu.utfpr.pedrocristovao.colecaovinil;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PessoaActivity extends AppCompatActivity {

    private EditText editTextNome, editTextMedia;
    private CheckBox checkBoxBolsista;

    private RadioGroup radioGroupMaoUsada;

    private Spinner spinnerTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);

        editTextNome = findViewById(R.id.editTextNome);
        editTextMedia = findViewById(R.id.editTextMedia);
        checkBoxBolsista = findViewById(R.id.checkBoxBolsista);
        radioGroupMaoUsada = findViewById(R.id.radioGroupMaoUsada);
        spinnerTipo = findViewById(R.id.spinnerTipo);

        //comentado, pois será usado lista de strings fixa do arquivo resource arrays.xml, propriedade "Entries"
        //popularSpinner();
    }

    private void popularSpinner(){

        ArrayList<String> lista = new ArrayList<>();

        lista.add(getString(R.string.aluno));
        lista.add(getString(R.string.monitor));
        lista.add(getString(R.string.tutor));
        lista.add(getString(R.string.professor));
        lista.add(getString(R.string.coordenador));

        //adapter vai renderizar cada linha do spinner / toString do objeto a ser exibido
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                                         android.R.layout.simple_list_item_1,
                                                         lista);
        //vimcular array ao adapter
        spinnerTipo.setAdapter(adapter);

        //adapter fará a renderização
        //spinner o controle
        //arrayList será a fonte de dados

    }
    public void limparCampos(View view){

        editTextNome.setText(null);
        editTextMedia.setText(null);
        checkBoxBolsista.setChecked(false);
        editTextNome.requestFocus();
        radioGroupMaoUsada.clearCheck();
        spinnerTipo.setSelection(0); //sempre vai ter um valor selecionado.

        Toast.makeText(this,
                       R.string.as_entradas_foram_apagadas,
                       Toast.LENGTH_LONG).show();
    }

    public void salvarValores(View view){
        String nome = editTextNome.getText().toString();

        if (nome == null || nome.trim().isEmpty()){
            Toast.makeText(this,
                            R.string.faltou_entrar_com_o_nome,
                            Toast.LENGTH_LONG).show();

            editTextNome.requestFocus();
            return;
        }

        nome = nome.trim();

        String mediaString = editTextMedia.getText().toString();

        if (mediaString == null || mediaString.trim().isEmpty()){
            Toast.makeText(this,
                    R.string.faltou_entrar_com_a_media,
                    Toast.LENGTH_LONG).show();

            editTextMedia.requestFocus();
            return;
        }

        int media = 0;

        try {
            media  = Integer.parseInt(mediaString);

        } catch (NumberFormatException e) {
            Toast.makeText(this,
                           R.string.media_deve_ser_um_numero_inteiro,
                           Toast.LENGTH_LONG).show();
            editTextMedia.requestFocus();
            editTextMedia.setSelection(0, editTextMedia.getText().toString().length());
            return;
        }

        if (media < 0 || media > 100){
            Toast.makeText(this,
                           R.string.media_deve_ser_entre_0_e_100,
                            Toast.LENGTH_LONG).show();
            editTextMedia.requestFocus();
            editTextMedia.setSelection(0, editTextMedia.getText().toString().length());
            return;
        }

        int radioButtonId = radioGroupMaoUsada.getCheckedRadioButtonId();

        String maoUsada;

        if(radioButtonId == R.id.radioButtonDireita){
            maoUsada = getString(R.string.direita);
        } else
            if (radioButtonId == R.id.radioButtonEsquerda){
                maoUsada = getString(R.string.esquerda);
            }else
                if (radioButtonId == R.id.radioButtonAmbas){
                    maoUsada = getString(R.string.ambas);
                }else{
                    Toast.makeText(this,
                            R.string.faltou_preencher_a_mao_usada,
                            Toast.LENGTH_LONG).show();
                    return;
                }

        String tipo = (String) spinnerTipo.getSelectedItem();

        if (tipo == null){
            Toast.makeText(this,
                           R.string.faltou_exibir_tipos_no_spinner,
                            Toast.LENGTH_LONG).show();
            return;
        }



        boolean bolsista = checkBoxBolsista.isChecked();

        Toast.makeText(this,
                        getString(R.string.nome_valor) + nome + "\n" +
                        getString(R.string.media_valor) + media + "\n" +
                                (bolsista ? getString(R.string.possui_bolsa) : getString(R.string.nao_possui_bolsa) ) + "\n" +
                        getString(R.string.mao_usada) + maoUsada + "\n" +
                        getString(R.string.tipo) + tipo,
                        Toast.LENGTH_LONG).show();

    }
}