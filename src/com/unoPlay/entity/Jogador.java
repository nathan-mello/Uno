package com.unoPlay.entity;

import java.util.ArrayList;

public class Jogador {
    private String name;
    private ArrayList<Carta> cartas;

    public Jogador(String name, ArrayList<Carta> cartas) {
        this.name = name;
        this.cartas = cartas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer cartaNaMao(){
        return cartas.size();
    }

    public boolean vitoria(){
        return cartas.isEmpty();
    }

    public void comprarCarta(Carta carta){
        cartas.add(carta);
    }

    public Carta jogada(Carta messa) {

        ArrayList<Carta> cartasJogada = new ArrayList<>();

        String cartasMao = "Suas Cartas: ";
        for (Carta carta: cartas) {
            cartasMao += carta.toString()+ "  ";
            if(carta.getNumber().equals(messa.getNumber())){
                    cartasJogada.add(carta);
            }else if(carta.getCor().equals(messa.getCor())){
                    cartasJogada.add(carta);
            }else if(carta.getNumber().equals(14)){
                    cartasJogada.add(carta);
            }
        }


        System.out.println(cartasMao);
        Carta cartaSelecionada = View.jogada(cartasJogada);
        if(cartaSelecionada == null){
            return null;
        }
        cartas.remove(cartaSelecionada);
        return cartaSelecionada;

    }

}
