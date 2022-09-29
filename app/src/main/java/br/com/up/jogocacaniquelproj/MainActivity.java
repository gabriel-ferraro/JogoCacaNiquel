/*package br.com.up.jogocacaniquelproj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int moeda;
    int pontos;

    private Button bt1;
    private Button bt2;
    private Button bt3;

    private Button apostar;
    private Button novoJogo;
    private Button sair;

    private TextView lbl_resultado_moeda;
    private TextView lbl_resultado_pontuacao;

    private Button bt4;
    private Button bt5;
    private Button bt6;

    private Button bt7;
    private Button bt8;
    private Button bt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);
        bt3 = findViewById(R.id.bt_3);

        apostar = findViewById(R.id.apostar);
        novoJogo = findViewById(R.id.novoJogo);
        sair = findViewById(R.id.sair);

        lbl_resultado_moeda = findViewById(R.id.lbl_resultado_moeda);
        lbl_resultado_pontuacao = findViewById(R.id.lbl_resultado_pontuacao);

        novoJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                moeda = 10;
                pontos = 0;
                bt1.setEnabled(true);
                bt2.setEnabled(true);
                bt3.setEnabled(true);
                apostar.setEnabled(true);
                lbl_resultado_moeda.setText("" + moeda);
                lbl_resultado_pontuacao.setText("" + pontos);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

            bt1.setEnabled(false);
            bt2.setEnabled(false);
            bt3.setEnabled(false);

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
            if(moeda == 0) {
                AlertDialog.Builder alertaPerdeu = new AlertDialog.Builder(this);
                alertaPerdeu.setTitle("Game Over");
                alertaPerdeu.setMessage("Acabou suas Moedas.");
                alertaPerdeu.setIcon(android.R.drawable.ic_delete);
                alertaPerdeu.setPositiveButton("OK", null);
                alertaPerdeu.create();
                alertaPerdeu.show();
                bt1.setEnabled(false);
                bt2.setEnabled(false);
                bt3.setEnabled(false);
            }
        }

    }
}*/

package br.com.up.jogocacaniquelproj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private Button btnInicial;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicial = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);

        btnInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent game = new Intent(
                        getApplicationContext(),
                        GameActivity.class
                );
                startActivity(game);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}