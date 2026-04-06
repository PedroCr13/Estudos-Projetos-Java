package br.edu.utfpr.abastecimentosveiculo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbastecimentosActivity extends AppCompatActivity {

    private List<Abastecimento> listaAbastecimentos;
    private ListView listViewAbastecimentos;
    private AbastecimentoAdapter abastecimentoAdapter;

    // deve ser ActionMode do AndroidX
    private ActionMode actionMode;
    private View viewSelecionada;
    private Drawable backgroundDrawable;
    private int posicaoSelecionada = -1;
    public static final String ARQUIVO_PREFERENCIAS = "br.edu.utfpr.abastecimentosveiculo.PREFERENCIAS";

    // chaves Shared preferences (ordenação)
    public static final String KEY_ORDENACAO_ASCENDENTE = "ORDENACAO_ASCENDENTE";
    private boolean ordenacaoAscendente = true; // ascendente / false descendente
    private MenuItem menuItemOrdenacao;
    private ActionMode.Callback actionCallBack = new ActionMode.Callback() {
        // Ouvidores:

        // Quando infla o menu (chamado uma vez)
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflate = mode.getMenuInflater();
            inflate.inflate(R.menu.abastecimentos_itemselecionado, menu);
            return true;
        }

        // Menu já criado, quer alterar em tempo de execução
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        // tratador de envento
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            int idMenuItem = item.getItemId();

            if (idMenuItem == R.id.menuItemEditar)
            {
                editarAbastecimento();
                return true;
            } else
            if (idMenuItem == R.id.menuItemExcluir) {
                excluirAbastecimento();
                mode.finish(); // fecha o ActionMode (fechar menu)
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

            // Ao fechar o menu volta para a cor original
            // estava cinza para dizer que a linha estava selecionada

            if (viewSelecionada != null)
            {
                viewSelecionada.setBackground(backgroundDrawable);
            }
            actionMode = null;
            viewSelecionada = null;
            backgroundDrawable = null;

            // habilita lista para ouvir eventos novamente
            listViewAbastecimentos.setEnabled(true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimentos);

        setTitle(getString(R.string.controle_dos_abastecimentos));

        listaAbastecimentos = new ArrayList<>();

        listViewAbastecimentos = findViewById(R.id.listViewAbastecimentos);

        lerPreferencias();

        popularListaAbastecimentos();

        registerForContextMenu(listViewAbastecimentos);
    }

    private void popularListaAbastecimentos()
    {
        abastecimentoAdapter = new AbastecimentoAdapter(this, listaAbastecimentos);

        listViewAbastecimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posicaoSelecionada = position;
                editarAbastecimento();
            }
        });

        listViewAbastecimentos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if (actionMode != null) {
                    return false;
                }

                posicaoSelecionada = position;

                viewSelecionada = view;
                backgroundDrawable = view.getBackground();
                view.setBackgroundColor(Color.LTGRAY);

                listViewAbastecimentos.setEnabled(false);

                actionMode = startSupportActionMode(actionCallBack);

                return true;
            }
        });
        listViewAbastecimentos.setAdapter(abastecimentoAdapter);
    }

    public void abrirSobre()
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
                            int posto = bundle.getInt(AbastecimentoActivity.KEY_POSTO);
                            int veiculo = bundle.getInt(AbastecimentoActivity.KEY_VEICULO);
                            String dataAbastecimento = bundle.getString(AbastecimentoActivity.KEY_DATAABASTECIMENTO);
                            double kmAtual = bundle.getDouble(AbastecimentoActivity.KEY_KMATUAL);
                            String combustivelTexto = bundle.getString(AbastecimentoActivity.KEY_COMBUSTIVEL);
                            int qtdLitros = bundle.getInt(AbastecimentoActivity.KEY_QTDLITROS);
                            double valorPago = bundle.getDouble(AbastecimentoActivity.KEY_VALORPAGO);
                            boolean calibrouPneu = bundle.getBoolean(AbastecimentoActivity.KEY_CALIBROUPNEU);

                            Abastecimento abastecimento = new Abastecimento(dataAbastecimento, veiculo, posto, kmAtual,
                                    Combustivel.valueOf(combustivelTexto), qtdLitros, valorPago, calibrouPneu);

                            listaAbastecimentos.add(abastecimento);

                            // ordenar por data do abastecimento conform escolha Shared Preferences:
                            ordenarLista();
                        }
                    }
                }
            });

    public void abrirNovoAbastecimento()
    {
        Intent intentAbertura = new Intent(this, AbastecimentoActivity.class);

        // Passar parâmetro de modo de abertura na chamada
        intentAbertura.putExtra(AbastecimentoActivity.KEY_MODO, AbastecimentoActivity.MODO_NOVO);

        launcherNovoAbastecimento.launch(intentAbertura);
    }

    // será executado uma vez, faz o menu aparecer na Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.abastecimentos_opcoes, menu);

        menuItemOrdenacao = menu.findItem(R.id.menuItemOrdenacao);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        atualziarIconeDaOrdenacao();
        return true;
    }

    // todos os menusItens tratados aqui
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // identificar quem foi clicado
        int idMenuItem = item.getItemId();

        if (idMenuItem == R.id.menuItemAdicionar)
        {
            abrirNovoAbastecimento();
            return true;
        } else
            if (idMenuItem == R.id.menuItemSobre)
            {
                abrirSobre();
                return true;
            } else
                if (idMenuItem == R.id.menuItemOrdenacao) {
                    salvarPreferenciaOrdenacaoAscendente(!ordenacaoAscendente);
                    atualziarIconeDaOrdenacao();
                    ordenarLista();
                    return true;
                }
                else
                {
                    return super.onOptionsItemSelected(item);
                }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.abastecimentos_itemselecionado, menu);
    }

    public void excluirAbastecimento() {
        listaAbastecimentos.remove(posicaoSelecionada);
        abastecimentoAdapter.notifyDataSetChanged();
    }

    // Metodo editarPessoa será chamado quanto voltar da edição
    ActivityResultLauncher<Intent> launcherEditarAbastecimento = registerForActivityResult(
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
                            String dataAbastecimento = bundle.getString(AbastecimentoActivity.KEY_DATAABASTECIMENTO);
                            int posto = bundle.getInt(AbastecimentoActivity.KEY_POSTO);
                            int veiculo = bundle.getInt(AbastecimentoActivity.KEY_VEICULO);
                            double kmAtual = bundle.getDouble(AbastecimentoActivity.KEY_KMATUAL);
                            String combustivelTexto = bundle.getString(AbastecimentoActivity.KEY_COMBUSTIVEL);
                            int qtdLitros = bundle.getInt(AbastecimentoActivity.KEY_QTDLITROS);
                            double valorPago = bundle.getDouble(AbastecimentoActivity.KEY_VALORPAGO);
                            boolean calibrouPneu = bundle.getBoolean(AbastecimentoActivity.KEY_CALIBROUPNEU);

                            Abastecimento abastecimento = listaAbastecimentos.get(posicaoSelecionada);

                            abastecimento.setData(dataAbastecimento);
                            abastecimento.setVeiculo(veiculo);
                            abastecimento.setPosto(posto);
                            abastecimento.setKmAtual(kmAtual);

                            Combustivel combustivel = Combustivel.valueOf(combustivelTexto);

                            abastecimento.setCombustivel(combustivel);

                            abastecimento.setQtdLitros(qtdLitros);
                            abastecimento.setValorPago(valorPago);
                            abastecimento.setCalibrouPneus(calibrouPneu);

                            // ordenação crescente da lista após setado todos os parametros:
                            // ordenando por data de abastecimento
                            ordenarLista();
                        }
                    }

                    // volta da tela
                    posicaoSelecionada = -1;

                    if (actionMode != null) {
                        actionMode.finish();
                    }
                }
            });

    private void editarAbastecimento()
    {
        // extrair dados do objeto da lista naquela posição:
        Abastecimento abastecimento = listaAbastecimentos.get(posicaoSelecionada);

        Intent intentAbertura = new Intent(this, AbastecimentoActivity.class);

        intentAbertura.putExtra(AbastecimentoActivity.KEY_MODO, AbastecimentoActivity.MODO_EDITAR);

        intentAbertura.putExtra(AbastecimentoActivity.KEY_DATAABASTECIMENTO, abastecimento.getData());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_VEICULO, abastecimento.getVeiculo());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_POSTO, abastecimento.getPosto());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_KMATUAL, abastecimento.getKmAtual());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_COMBUSTIVEL, abastecimento.getCombustivel().toString());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_QTDLITROS, abastecimento.getQtdLitros());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_VALORPAGO, abastecimento.getValorPago());
        intentAbertura.putExtra(AbastecimentoActivity.KEY_CALIBROUPNEU, abastecimento.isCalibrouPneus());

        // irá abrir a tela de cadastro já passando os dados para edicao
        launcherEditarAbastecimento.launch(intentAbertura);
    }

    private void ordenarLista() {

        if (ordenacaoAscendente) {
            Collections.sort(listaAbastecimentos, Abastecimento.ordenacaoCrescente);
        } else {
            Collections.sort(listaAbastecimentos, Abastecimento.ordenacaoDecrescente);
        }

        // Avisa que houve alterações, será renderizado novamente
        abastecimentoAdapter.notifyDataSetChanged();
    }

    private void atualziarIconeDaOrdenacao() {
        // troca do icone ordenação:
        if (ordenacaoAscendente) {
            menuItemOrdenacao.setIcon(R.drawable.ic_action_ascending_order);
        } else {
            menuItemOrdenacao.setIcon(R.drawable.ic_action_descending_order);
        }
    }

    private void lerPreferencias() {
        // modo privado: não está compartilhando
        SharedPreferences shared = getSharedPreferences(ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        ordenacaoAscendente = shared.getBoolean(KEY_ORDENACAO_ASCENDENTE, ordenacaoAscendente);
    }

    private void salvarPreferenciaOrdenacaoAscendente(boolean novoValor)
    {
        SharedPreferences shared = getSharedPreferences(ARQUIVO_PREFERENCIAS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putBoolean(KEY_ORDENACAO_ASCENDENTE, novoValor);

        editor.commit();

        ordenacaoAscendente = novoValor;
    }

}