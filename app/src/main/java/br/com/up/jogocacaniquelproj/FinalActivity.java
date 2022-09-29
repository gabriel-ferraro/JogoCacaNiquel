package br.com.up.jogocacaniquelproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.up.jogocacaniquelproj.adapters.JogoAdapter;
import br.com.up.jogocacaniquelproj.models.Jogo;
import br.com.up.jogocacaniquelproj.repositories.JogoRepository;

public class FinalActivity extends AppCompatActivity {

    private RecyclerView recyclerViewJogos;
    private Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        recyclerViewJogos = findViewById(R.id.recycler_view_jogos);
        buttonHome = findViewById(R.id.button_home);

        //cria o layout da recyclerView
        recyclerViewJogos.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //Voltar para home
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(home);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Jogo> jogos =
                JogoRepository.getInstance().getAll();

        recyclerViewJogos.setAdapter(
                new JogoAdapter(jogos)
        );

    }
}