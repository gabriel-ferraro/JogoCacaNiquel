package br.com.up.jogocacaniquelproj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import br.com.up.jogocacaniquelproj.models.Jogo;
import br.com.up.jogocacaniquelproj.repositories.JogoRepository;

public class GameActivity extends AppCompatActivity {

    int moeda;
    int pontos;

    private Button bt1;
    private Button bt2;
    private Button bt3;

    private Button apostar;
    private TextView lbl_resultado_moeda;
    private TextView lbl_resultado_pontuacao;
    private Button ButtonTerminarJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);
        bt3 = findViewById(R.id.bt_3);

        apostar = findViewById(R.id.apostar);
        ButtonTerminarJogo = findViewById(R.id.button_terminar_jogo);

        lbl_resultado_moeda = findViewById(R.id.lbl_resultado_moeda);
        lbl_resultado_pontuacao = findViewById(R.id.lbl_resultado_pontuacao);

        moeda = 10;
        pontos = 0;
        lbl_resultado_moeda.setText("" + moeda);
        lbl_resultado_pontuacao.setText("" + pontos);

        apostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i1, i2, i3; // Criando variaveis que serão os numeros mostrados nos botões

                Random r1 = new Random(); // Criando Random para cada um dos botões;
                Random r2 = new Random(); // Criando Random para cada um dos botões;
                Random r3 = new Random(); // Criando Random para cada um dos botões;

                i1 = r1.nextInt(10); // Atribuindo o random para as variaveis até um numero maximo de 10;
                i2 = r2.nextInt(10); // Atribuindo o random para as variaveis até um numero maximo de 10;
                i3 = r3.nextInt(10); // Atribuindo o random para as variaveis até um numero maximo de 10;

                bt1.setText(String.valueOf(i1)); // Setando os valores para aparecerem no botão
                bt2.setText(String.valueOf(i2)); // Setando os valores para aparecerem no botão
                bt3.setText(String.valueOf(i3)); // Setando os valores para aparecerem no botão

                checarJogo(i1, i2, i3);
            }
        });

        ButtonTerminarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               terminarJogo();
            }
        });

    }

    public void checarJogo(int a, int b, int c){

        if((a==7) && (b==7) && (c==7)) {

            moeda = moeda + 10;
            pontos = pontos + 100;

            AlertDialog.Builder alertaVenceu = new AlertDialog.Builder(this);
            alertaVenceu.setTitle("VENCEU!!!");
            alertaVenceu.setMessage("JACKPOT! VOCÊ ACERTOU EM CHEIO!");
            alertaVenceu.setIcon(android.R.drawable.star_on);
            alertaVenceu.setPositiveButton("OK", null);
            alertaVenceu.create();
            alertaVenceu.show();

            lbl_resultado_moeda.setText(String.valueOf(moeda));
            lbl_resultado_pontuacao.setText(String.valueOf(pontos));

        } else if((a==7) && (b==7) || (b==7) && (c==7) || (c==7) && (a==7)) {
            moeda = moeda + 5;
            pontos = pontos + 50;
            lbl_resultado_moeda.setText(String.valueOf(moeda));
            lbl_resultado_pontuacao.setText(String.valueOf(pontos));
        } else if(a==7 || b==7 || c==7) {
            moeda = moeda + 2;
            pontos = pontos + 20;
            lbl_resultado_moeda.setText(String.valueOf(moeda));
            lbl_resultado_pontuacao.setText(String.valueOf(pontos));
        } else if(a!=7 && b!=7 && c!=7) {
            moeda = moeda - 1;
            lbl_resultado_moeda.setText(String.valueOf(moeda));
            lbl_resultado_pontuacao.setText(String.valueOf(pontos));
        }

        if(moeda == 0) {
            AlertDialog.Builder alertaPerdeu = new AlertDialog.Builder(this);
            alertaPerdeu.setTitle("Game Over");
            alertaPerdeu.setMessage("Acabou suas Moedas - Pontuação: " + lbl_resultado_pontuacao.getText().toString());
            alertaPerdeu.setIcon(android.R.drawable.ic_delete);

            alertaPerdeu.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(GameActivity.this, FinalActivity.class);
                    startActivity(i);
                    //startActivity(new Intent(getBaseContext(),FinalActivity.class));
                }
            });
            alertaPerdeu.create().show();
            salvarJogo();
        }
    }

    public void terminarJogo(){

        AlertDialog.Builder jogoTerminado = new AlertDialog.Builder(this);
        jogoTerminado.setTitle("Fim do jogo");
        jogoTerminado.setMessage("Você finalizou seu jogo - Pontuação: "
                + lbl_resultado_pontuacao.getText().toString()
                + " Moedas: "
                + lbl_resultado_moeda.getText().toString());
        jogoTerminado.setIcon(android.R.drawable.star_on);

        jogoTerminado.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(GameActivity.this, FinalActivity.class);
                startActivity(i);
                //startActivity(new Intent(getBaseContext(),FinalActivity.class));
            }
        });
        jogoTerminado.create().show();
        salvarJogo();
    }

    private void salvarJogo() {
        int numero;
        String moedas = lbl_resultado_moeda.getText().toString();
        String pontuacao = lbl_resultado_pontuacao.getText().toString();

        Jogo jogo = new Jogo(
                moedas,
                pontuacao
        );

        JogoRepository.getInstance().save(jogo);
    }
}

