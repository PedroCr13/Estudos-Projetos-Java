package br.edu.utfpr.abastecimentosveiculo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.utfpr.abastecimentosveiculo.modelo.Abastecimento;

public class AbastecimentoAdapter extends BaseAdapter {

    private Context context;
    private List<Abastecimento> listaAbastecimentos;

    private String[] veiculos;
    private String[] postos;

    private static class AbastecimentoHolder {
        public TextView textViewValorData;
        public TextView textViewValorVeiculo;
        public TextView textViewValorPosto;
        public TextView textViewValorKmAtual;
        public TextView textViewValorCombustivel;
        public TextView textViewValorLitros;
        public TextView textViewValorValorPago;
        public TextView textViewPneusCalibrados;
    }

    public AbastecimentoAdapter(Context context, List<Abastecimento> listaAbastecimentos) {
        this.context = context;
        this.listaAbastecimentos = listaAbastecimentos;

        veiculos = context.getResources().getStringArray(R.array.veiculos);
        postos = context.getResources().getStringArray(R.array.postos);
    }

    @Override
    public int getCount() {
        return listaAbastecimentos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAbastecimentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AbastecimentoHolder holder;

        if (convertView  == null){
            //não foi criado
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.linha_lista_abastecimentos, parent, false);

            holder = new AbastecimentoHolder();

            holder.textViewValorData = convertView.findViewById(R.id.textViewValorData);
            holder.textViewValorVeiculo = convertView.findViewById(R.id.textViewValorVeiculo);
            holder.textViewValorPosto = convertView.findViewById(R.id.textViewValorPosto);
            holder.textViewValorKmAtual = convertView.findViewById(R.id.textViewValorKmAtual);
            holder.textViewValorCombustivel = convertView.findViewById(R.id.textViewValorCombustivel);
            holder.textViewValorLitros = convertView.findViewById(R.id.textViewValorQtdLitros);
            holder.textViewValorValorPago = convertView.findViewById(R.id.textViewValorValorPago);
            holder.textViewPneusCalibrados = convertView.findViewById(R.id.textViewValorCalibrouPneus);

            //associa holder ao view
            convertView.setTag(holder);
        } else {
            //atualiza linha existente
            holder = (AbastecimentoHolder) convertView.getTag();
        }

        //colocar valores na interface
        Abastecimento abastecimento = listaAbastecimentos.get(position);
        holder.textViewValorData.setText(abastecimento.getData());
        holder.textViewValorVeiculo.setText(veiculos[abastecimento.getVeiculo()]);
        holder.textViewValorPosto.setText(postos[abastecimento.getPosto()]);
        holder.textViewValorKmAtual.setText(String.valueOf(abastecimento.getKmAtual()));

        switch (abastecimento.getCombustivel()){
            case Etanol:
                holder.textViewValorCombustivel.setText(R.string.opcao_etanol);
                break;

            case Gasolina:
                holder.textViewValorCombustivel.setText(R.string.opcao_gasolina);
                break;
        }

        holder.textViewValorLitros.setText(String.valueOf(abastecimento.getQtdLitros()));
        holder.textViewValorValorPago.setText(String.valueOf(abastecimento.getValorPago()));

        if (abastecimento.isCalibrouPneus()){
            holder.textViewPneusCalibrados.setText(R.string.penus_calibrados);
        } else {
            holder.textViewPneusCalibrados.setText(R.string.pneus_nao_calibrados);
        }

        return convertView;
    }
}
