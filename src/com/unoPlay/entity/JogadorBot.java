package com.unoPlay.entity;

import java.util.ArrayList;

public class JogadorBot extends Jogador{
    ArrayList<Carta> cartas;
    String name;

    public JogadorBot(String name, ArrayList<Carta> cartas) {
        super(name, cartas);
        this.cartas = cartas;
        this.name = name;
    }

    @Override
    public Carta jogada(Carta messa) {

        ArrayList<Carta> cartasJogada = new ArrayList<>();

        for (Carta carta: cartas) {
            if(carta.getNumber().equals(messa.getNumber())){
                cartasJogada.add(carta);
            }else if(carta.getCor().equals(messa.getCor())){
                cartasJogada.add(carta);
            }else if(carta.getCor().equals("preto")){
                cartasJogada.add(carta);
            }
        }

        if (cartasJogada.isEmpty()){
            return null;
        }else{
            Carta carta = cartasJogada.remove(0);
            cartas.remove(carta);
            return carta;
        }
    }
}