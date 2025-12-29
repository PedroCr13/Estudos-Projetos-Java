package br.edu.utfpr.pedrocristovao.colecaovinil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//quando fez o adapter do listview(projeto anterior, se baseou no BaseAdapter)
//irá RecycleVIew.Adapter<> irá obrigar implementar alguns metodos
//botão direito
public class PessoaRecycleViewAdapter extends RecyclerView.Adapter<PessoaRecycleViewAdapter.PessoaHolder> {

    private OnItemClickListener onItemClickListener;
    private Context context; //para poder acessar o arquivo resources
    private List<Pessoa> listaPessoas;
    private String[] tipos;

    public interface OnItemClickListener {
        void onItemclick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    //classe que será responsável pela renderização de cada linha do recycle view

    //obrigado a fazer o holder no RecycleView

    //classe interna
    public class PessoaHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        //guarda os endereços de cada elemento da linha
        //para nao precisar ficar repetindo código toda hora
        public TextView textViewValorNome;
        public TextView textValorMedia;
        public TextView textViewValorBolsista;
        public TextView textViewValorTipo;
        public TextView textViewValorMaoUsada;

        //obrigatorio implementar constructor (botao direito clicar na lampada)
        public PessoaHolder(@NonNull View itemView) {
            super(itemView); //no RecycleVIew não precisa fazer os testes para saber se a linha foi criada
            //o super fará isso, se for a primeira vez ele criará
            //retornará itemView que é a linha.

            //seta valores para dos atributos do holder:
            textViewValorNome = itemView.findViewById(R.id.textViewValorNome);
            textValorMedia = itemView.findViewById(R.id.textViewValorMedia);
            textViewValorBolsista = itemView.findViewById(R.id.textViewValorBolsista);
            textViewValorTipo = itemView.findViewById(R.id.textViewValorTipo);
            textViewValorMaoUsada = itemView.findViewById(R.id.textViewMaoUsadaValor);

            // (itemView é a linha)
            //quando alguem clicar, quem vai atender é o holder (this)
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //pasou um objeto diferente de null no construtor
            if (onItemClickListener != null){
                int pos = getAdapterPosition();

                //alguma linha foi clicada pelo usuário
                if (pos != RecyclerView.NO_POSITION){
                    onItemClickListener.onItemclick(v, pos);
                }
            }
        }

        @Override
        public boolean onLongClick(View v) {

            if (onItemClickListener != null){
                int pos = getAdapterPosition();

                //alguma linha foi clicada pelo usuário
                if (pos != RecyclerView.NO_POSITION){
                    onItemClickListener.onItemLongClick(v, pos);
                    return true;
                }
            }

            return false;
        }
    }

    //criar construtor com context e lista pessoas
    public PessoaRecycleViewAdapter(Context context, List<Pessoa> listaPessoas, OnItemClickListener listener) {
        this.context      = context;
        this.listaPessoas = listaPessoas;
        this.onItemClickListener = listener;

        //instaciar array de tipos:
        //para colocar as constantes tipos dentro do array de strings
        tipos = context.getResources().getStringArray(R.array.tipos);
    }

    @NonNull
    @Override
    public PessoaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //cria todos os objetos alocados em memória alinhados com o parent (listView)
        View convertView = inflater.inflate(R.layout.linha_lista_pessoas, parent, false);

        return new PessoaHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull PessoaHolder holder, int position) {
        //quando trocar os valores da linha, ex movimentação de tela, apresentar valores de outro objeto
        //este metodo traz os dados e atualiza os campos
        //pega objeto na lista de acordo com a posição que o onBind fornece e joga valores nos campos
        Pessoa pessoa = listaPessoas.get(position);

        holder.textViewValorNome.setText(pessoa.getNome());
        holder.textValorMedia.setText(String.valueOf(pessoa.getMedia()));

        if (pessoa.isBolsista()){
            holder.textViewValorBolsista.setText(R.string.possui_bolsa);
        } else {
            holder.textViewValorBolsista.setText(R.string.nao_possui_bolsa);
        }

        //pega a posição do vetor que veio lá do resource arrays que foi colocado no atributo privado no oncreate
        holder.textViewValorTipo.setText(tipos[pessoa.getTipo()]);

        switch (pessoa.getMaoUsada()){
            case Direita://não usar Enum direto no campo para facilitar tradução, pegar string.
                holder.textViewValorMaoUsada.setText(R.string.direita);
                break;

            case Esquerda:
                holder.textViewValorMaoUsada.setText(R.string.esquerda);
                break;

            case Ambas:
                holder.textViewValorMaoUsada.setText(R.string.ambas);
                break;
        }
    }

    @Override
    public int getItemCount() {
        //tamanho do arrayList
        return listaPessoas.size();
    }
}
