package br.edu.utfpr.pedrocristovao.colecaovinil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PessoasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPessoas; //novo
    private RecyclerView.LayoutManager layoutManager; //novo
    private PessoaRecycleViewAdapter pessoaRecycleViewAdapter;
    private List<Pessoa> listaPessoas;
    private PessoaRecycleViewAdapter.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoas);

        recyclerViewPessoas = findViewById(R.id.recycleViewPessoas);

        //gerenciador de layout
        layoutManager = new LinearLayoutManager(this);
        //por padrão tem que definir layout
        recyclerViewPessoas.setLayoutManager(layoutManager);
        //true: não altera valores das linhas enquanto mostradas.
        recyclerViewPessoas.setHasFixedSize(true);
        //acrescenta um divisor de linhas
        recyclerViewPessoas.addItemDecoration(new DividerItemDecoration(this,
                LinearLayout.VERTICAL));

        onItemClickListener = new PessoaRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemclick(View view, int position) {
                Pessoa pessoa = listaPessoas.get(position);

                Toast.makeText(getApplicationContext(),
                        getString(R.string.pessoa_de_nome) + pessoa.getNome() + getString(R.string.foi_clicada),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Pessoa pessoa = listaPessoas.get(position);

                Toast.makeText(getApplicationContext(),
                        getString(R.string.pessoa_de_nome) + pessoa.getNome() + getString(R.string.recebeu_um_clique_longo),
                        Toast.LENGTH_LONG).show();
            }
        };

        popularListaPessoas();
    }

    private void popularListaPessoas(){
        //vai ler o string-array do arrays.xml e devolver as 10 posições
        String[] pessoas_nomes    = getResources().getStringArray(R.array.pessoas_nome);
        int[] pessoas_medias      = getResources().getIntArray(R.array.pessoas_media);
        int[] pessoa_bolsistas    = getResources().getIntArray(R.array.pessoas_bolsistas);
        int[] pessoas_tipos       = getResources().getIntArray(R.array.pessoas_tipos);
        int[] pessoas_maos_usadas = getResources().getIntArray(R.array.pessoas_maos_usadas);

        listaPessoas = new ArrayList<>();

        Pessoa pessoa;
        boolean bolsista;
        MaoUsada maoUsada;

        MaoUsada[] maosUsadas = MaoUsada.values(); //retorna um array com valores de mãos usadas

        //criar objetos pessoa em uma lista
        for(int cont = 0; cont < pessoas_nomes.length; cont++){
            //se o valor da posição for 1 retorna true, senão false (operador ternário)
            bolsista = (pessoa_bolsistas[cont] == 1 ? true : false);

            //a posição atual vai virar indice do vetor maosUsadas
            //recupera o valor inteiro 0, 1 ou 2 usa ele para indice do maosUsadas[]
            //quem tem as constantes direita, esquerda ou ambas e
            //atribui a variavel maoUsada
            maoUsada = maosUsadas[pessoas_maos_usadas[cont]];

            pessoa = new Pessoa(pessoas_nomes[cont],
                    pessoas_medias[cont],
                    bolsista, //convertido
                    pessoas_tipos[cont],
                    maoUsada); // convertido
            listaPessoas.add(pessoa);
        }
        /**
         * nao ira mais usar este trecho, agora vai criar um view personalizado
        //vimcular dados em um adapter
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listaPessoas);
        */
        pessoaRecycleViewAdapter = new PessoaRecycleViewAdapter(this, listaPessoas, onItemClickListener);

        //o listView vai mostrar objetos, por padrão pelo metodo toString() da classe Pessoa
        //sobrescrever ele na classe Pessoa para mostrar os atributos ao invés de endereço de memória
        recyclerViewPessoas.setAdapter(pessoaRecycleViewAdapter);
    }
}