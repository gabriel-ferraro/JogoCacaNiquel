package br.com.up.jogocacaniquelproj.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import br.com.up.jogocacaniquelproj.R;
import br.com.up.jogocacaniquelproj.models.Jogo;

public class JogoAdapter extends RecyclerView.Adapter<JogoAdapter.JogoViewHolder> {

    private ArrayList<Jogo> jogos;

    public JogoAdapter(ArrayList<Jogo> jogos){
        this.jogos = jogos;
    }

    @NonNull
    @Override
    public JogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        //Infla o viewItemJogo para que o mesmo possa ser um viewItem da recyclerView
        View layout = layoutInflater.inflate(
                R.layout.view_item_jogo,
                parent,
                false
        );

        return new JogoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull JogoViewHolder holder, int position) {

        Jogo jogo = jogos.get(position);

        TextView textViewMoedas =
                holder.itemView.findViewById(R.id.text_view_item_moedas);
        TextView textViewPontuacao =
                holder.itemView.findViewById(R.id.text_view_item_pontuacao);

        textViewMoedas.setText(jogo.getMoedas());
        textViewPontuacao.setText(jogo.getPontos());
    }

    @Override
    public int getItemCount() {
        return jogos.size();
    }

    public static class JogoViewHolder
            extends RecyclerView.ViewHolder{

        public JogoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
