package br.com.up.jogocacaniquelproj.repositories;

import java.util.ArrayList;

import br.com.up.jogocacaniquelproj.models.Jogo;

public class JogoRepository {

    private static JogoRepository repository;
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public static JogoRepository getInstance(){

        if(repository == null){
            repository = new JogoRepository();
        }
        return repository;

    }

    private JogoRepository(){ }

    public void save(Jogo jogo){
        jogos.add(jogo);
    }

    public ArrayList<Jogo> getAll(){
        return jogos;
    }
}
