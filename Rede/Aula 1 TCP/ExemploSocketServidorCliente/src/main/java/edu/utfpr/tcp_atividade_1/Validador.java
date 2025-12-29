package edu.utfpr.tcp_atividade_1;

//@author Pedro Cristovão lopes fogaça

public class Validador {

    private String cpf;
    private int[] digitos = new int[9];

    public Validador(String cpf) {
        this.cpf = cpf.replaceAll("\\D", "");
    }

    public boolean cpfValido() {
        if (cpf.length() > 11)
            return false;

        if (cpf.equals("00000000000"))
            return false;

        if (contemDigitoRepetido())
            return false;

        inverteDigitos();

        int dv1 = calculaPenultimoDv();
        int dv2 = calculaUltimoDv(dv1);

        String dvRecebido = cpf.substring(9);
        String dvCalculado = dv1 + "" + dv2;

        if (dvRecebido.equals(dvCalculado))
            return true;
        else
            return false;
    }

    private void inverteDigitos(){
        digitos[0] = Integer.parseInt(cpf.substring(8, 9));
        digitos[1] = Integer.parseInt(cpf.substring(7 ,8));
        digitos[2] = Integer.parseInt(cpf.substring(6, 7));
        digitos[3] = Integer.parseInt(cpf.substring(5, 6));
        digitos[4] = Integer.parseInt(cpf.substring(4, 5));
        digitos[5] = Integer.parseInt(cpf.substring(3, 4));
        digitos[6] = Integer.parseInt(cpf.substring(2, 3));
        digitos[7] = Integer.parseInt(cpf.substring(1, 2));
        digitos[8] = Integer.parseInt(cpf.substring(0, 1));
    }

    private int calculaPenultimoDv(){
        int fator = 2;
        int soma = 0;
        int dv = 0;
        int modulo = 0;

        for (int i = 0; i < digitos.length; i++) {
            soma = soma + digitos[i] * fator;
            fator++;
        }

        modulo = soma % 11;

        if (modulo < 2)
            dv = 0;
         else if(modulo >= 2) {
            dv = (11 - (int)modulo);
        }
        return dv;
    }

    private int calculaUltimoDv(int dv1) {
        int fator = 2;
        int soma = 0;
        int dv = 0;
        int modulo = 0;

        soma = dv1 * 2;
        fator++;

        for (int i = 0; i < digitos.length; i++) {
            soma = soma + digitos[i] * fator;
            fator++;
        }

        modulo = soma % 11;

        if (modulo < 2)
            dv = 0;
        else if(modulo >= 2)
            dv = 11 - (int)modulo;

        return dv;
    }

    private boolean contemDigitoRepetido(){
        char primeiro = cpf.charAt(0);

        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != primeiro) {
                return false;
            }
        }
        return true;
    }
}
