package br.edu.utfpr.abastecimentosveiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

public class Abastecimento {
    private String data;
    private int veiculo;
    private int posto;
    private double kmAtual;
    private Combustivel combustivel;
    private int qtdLitros;
    private double valorPago;
    private boolean calibrouPneus;
    public static Comparator<Abastecimento> ordenacaoDecrescente = new Comparator<Abastecimento>() {
        // Compara de 2 em 2
        // necessário converter as datas que estão como String para realizar as comparações:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public int compare(Abastecimento a1, Abastecimento a2) {
            try {
                Date d1 = sdf.parse(a1.getData());
                Date d2 = sdf.parse(a2.getData());
                return d2.compareTo(d1);
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        }
    };

    public Abastecimento(String data, int veiculo, int posto, double kmAtual, Combustivel combustivel,
                         int qtdLitros, double valorPago, boolean calibrouPneus) {
        this.data = data;
        this.veiculo = veiculo;
        this.posto = posto;
        this.kmAtual = kmAtual;
        this.combustivel = combustivel;
        this.qtdLitros = qtdLitros;
        this.valorPago = valorPago;
        this.calibrouPneus = calibrouPneus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(int veiculo) {
        this.veiculo = veiculo;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    public double getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(double kmAtual) {
        this.kmAtual = kmAtual;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public int getQtdLitros() {
        return qtdLitros;
    }

    public void setQtdLitros(int qtdLitros) {
        this.qtdLitros = qtdLitros;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public boolean isCalibrouPneus() {
        return calibrouPneus;
    }

    public void setCalibrouPneus(boolean calibrouPneus) {
        this.calibrouPneus = calibrouPneus;
    }

    @Override
    public String toString() {
        return  data + "\n" +
                veiculo + "\n" +
                posto + "\n" +
                kmAtual + "\n" +
                combustivel + "\n" +
                qtdLitros + "\n" +
                valorPago + "\n" +
                calibrouPneus;
    }
}
