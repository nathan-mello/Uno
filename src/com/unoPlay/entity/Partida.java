package com.unoPlay.entity;

import java.util.ArrayList;

public class Partida {
    private final Baralho baralho = new Baralho();
    private final DoubleLinkedList jogadores;
    private Carta messa;

    public Partida(String name) {
        this.messa = baralho.criarFirstCartas();
        ArrayList<Jogador> jg = new ArrayList<>();
        jg.add(new Jogador(name, baralho.getSeisCartas()));
        jg.add(new JogadorBot("marta", baralho.getSeisCartas()));
        jg.add(new JogadorBot("maria", baralho.getSeisCartas()));
        jg.add(new JogadorBot("marcos", baralho.getSeisCartas()));
        jogadores = new DoubleLinkedList(jg);
    }

    public void iniciarPartida(){
        boolean cont = true;
        Jogador jg;
        while(cont){
            jg = jogadores.getPonteiro();
            Carta carta = jg.jogada(messa);

            if (carta == null) {
                jg.comprarCarta(baralho.getUmaCarta());


            } else {
                messa = carta;
                View.println("O Jogador " + jg.getName() + " jogou a carta " + carta.toString());
            }

            if (jg.vitoria()) {
                System.out.println("Vitoria: " + jg.getName());
                cont = false;
            }else{
                jogadores.nextJogador();
            }
        }
    }


}
