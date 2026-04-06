package br.edu.utfpr.abastecimentosveiculo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        setTitle(R.string.sobre);
    }

    // quando clicar no nome autor direcionar para página:
    public void abrirSiteDeAutoria(View view)
    {
        abrirSite("https://www.linkedin.com/in/pedrolopes1208");
    }

    // Intent Implícita
    private void abrirSite(String endereco)
    {
        // Intent com ação
        Intent intentAbertura = new Intent(Intent.ACTION_VIEW);

        intentAbertura.setData(Uri.parse(endereco));

        // verifica se existe activity para acessar endereço web
        // se retornar diferente de null, encontrou alguem que atende o pedido:
        if (intentAbertura.resolveActivity(getPackageManager()) != null)
        {
            // passará para maquina virtual chamar a responsavel pela abertura do site
            startActivity(intentAbertura);
        }
        else
        {
            Toast.makeText(this,
                    R.string.nao_encontrado_app_para_abrir_site,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void enviarEmailAutor(View view)
    {
        enviarEmail(new String[] {"pedro.fogaca@utfpr.edu.br"},
                getString(R.string.contato_pelo_aplicativo_controle_de_abastecimentos));
    }

    private void enviarEmail(String[] enderecos, String assunto)
    {
        Intent intentAbertura = new Intent(Intent.ACTION_SENDTO);

        intentAbertura.setData(Uri.parse("mailto:"));
        intentAbertura.putExtra(Intent.EXTRA_EMAIL, enderecos);
        intentAbertura.putExtra(intentAbertura.EXTRA_SUBJECT, assunto);

        // Procura alguém para enviar o email
        if (intentAbertura.resolveActivity(getPackageManager()) != null)
        {
            // passará para maquina virtual chamar a responsavel pela abertura do site
            startActivity(intentAbertura);
        }
        else
        {
            Toast.makeText(this,
                    R.string.nenhum_aplicativo_para_enviar_o_email,
                    Toast.LENGTH_LONG).show();
        }
    }

   /*
   // forma de Interceptar botão Up (configurado no manifest SingleTask)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idMenuItem = item.getItemId();

        if (idMenuItem == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    */
}