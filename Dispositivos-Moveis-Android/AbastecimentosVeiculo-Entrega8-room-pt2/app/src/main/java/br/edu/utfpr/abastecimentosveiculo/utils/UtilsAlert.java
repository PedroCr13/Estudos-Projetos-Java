package br.edu.utfpr.abastecimentosveiculo.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import br.edu.utfpr.abastecimentosveiculo.R;

public final class UtilsAlert {

    private UtilsAlert() {
        // evitar que a classe seja instanciada.
        // ninugém consegue acessar este construtor
    }

    public static void mostrarAviso(Context context, int idMensagemStringXML) {

        mostrarAviso(context, context.getString(idMensagemStringXML), null);
    }

    public static void mostrarAviso(Context context, int idMensagemStringXML,
                                    DialogInterface.OnClickListener listener) {

        mostrarAviso(context, context.getString(idMensagemStringXML), listener);

    }

    public static void mostrarAviso(Context context,
                                    String mensagem,
                                    DialogInterface.OnClickListener listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(R.string.aviso);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage(mensagem);

        builder.setNeutralButton(R.string.ok, listener);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // Metodo de dialogo com confirmação
    public static void ConfirmarAcao(Context context, int idMensagemStringXML,
                                     DialogInterface.OnClickListener listenerSim,
                                     DialogInterface.OnClickListener listenerNao) {

        confirmarAcao(context, context.getString(idMensagemStringXML), listenerSim, listenerNao);
    }

    public static void confirmarAcao(Context context,
                                     String mensagem,
                                     DialogInterface.OnClickListener listenerSim,
                                     DialogInterface.OnClickListener listenerNao) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(R.string.confirmacao);
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setMessage(mensagem);

        builder.setPositiveButton(R.string.sim, listenerSim);
        builder.setNegativeButton(R.string.nao, listenerNao);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
