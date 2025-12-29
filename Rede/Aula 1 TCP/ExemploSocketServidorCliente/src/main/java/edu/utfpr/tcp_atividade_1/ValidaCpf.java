package edu.utfpr.tcp_atividade_1;

//@author Pedro Cristovão lopes fogaça

public class ValidaCpf {

    public static boolean validaCpf(String cpf) {

        int[] digitos = new int[9];
        int[] multiplicacaoFase1 = new int[9];
        int[] multiplicacaoFase2 = new int[10];
        int fator = 2;
        int soma = 0;
        int dv1 = 0;
        int dv2 = 0;
        double modulo = 0;
        int qtdDigitos = 0;
        String dvRecebido = "";
        String dvCalculado = "";
        qtdDigitos = cpf.length();

        if (qtdDigitos > 11) {
            return false;
        }

        dvRecebido = cpf.substring(9);

        digitos[0] = Integer.parseInt(cpf.substring(8, 9));
        digitos[1] = Integer.parseInt(cpf.substring(7 ,8));
        digitos[2] = Integer.parseInt(cpf.substring(6, 7));
        digitos[3] = Integer.parseInt(cpf.substring(5, 6));
        digitos[4] = Integer.parseInt(cpf.substring(4, 5));
        digitos[5] = Integer.parseInt(cpf.substring(3, 4));
        digitos[6] = Integer.parseInt(cpf.substring(2, 3));
        digitos[7] = Integer.parseInt(cpf.substring(1, 2));
        digitos[8] = Integer.parseInt(cpf.substring(0, 1));

        //Penultimo digito:

        for (int i = 0; i < digitos.length; i++) {
            multiplicacaoFase1[i] = digitos[i] * fator;
            soma = soma + multiplicacaoFase1[i];
            fator++;
        }

        modulo = soma % 11;

        if (modulo < 2) {
            dv1 = 0;
        }
        else if(modulo >= 2) {
            dv1 = 11 - (int)modulo;
        }

        //ultimo digito:
        fator = 2;

        multiplicacaoFase2[9] = dv1 * 2;
        soma = multiplicacaoFase2[9];
        fator++;

        for (int i = 0; i < digitos.length; i++) {
            multiplicacaoFase2[i] = digitos[i] * fator;
            soma = soma + multiplicacaoFase2[i];
            fator++;
        }

        modulo = soma % 11;

        if (modulo < 2) {
            dv2 = 0;
        }
        else if(modulo >= 2) {
            dv2 = 11 - (int)modulo;
        }

        System.out.print("DV: " + dv1 +""+ dv2);

        dvCalculado = dv1 + "" + dv2;

        if (dvRecebido.equals(dvCalculado))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        String cpf = "37452764854";

        //validaCpf(cpf);

        Validador v = new Validador(cpf);

        if (v.cpfValido()){
            System.out.println("Valido!");
        } else {
            System.out.println("Invalido!");
        }
    }
}
