package br.com.up.jogocacaniquelproj.models;

public class Jogo {

    private String moedas;
    private String pontos;

    public Jogo(String moedas, String pontos) {
        this.moedas = moedas;
        this.pontos = pontos;
    }

    public String getMoedas() {
        return moedas;
    }

    //public void setMoedas(String moedas) { this.moedas = moedas; }

    public String getPontos() {
        return pontos;
    }

    //public void setPontos(String pontos) { this.pontos = pontos; }
}
