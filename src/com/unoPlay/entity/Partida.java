package com.unoPlay.entity;

import java.util.Iterator;
import java.util.LinkedList;

public class Partida {
    private final Baralho baralho = new Baralho();
    private LinkedList <Jogador> jogadores = new LinkedList<Jogador>();
    private Carta messa;

    public Partida(String name) {
        this.messa = baralho.criarFirstCartas();
        jogadores.add(new Jogador(name, baralho.getSeisCartas()));
        jogadores.add(new JogadorBot("marta", baralho.getSeisCartas()));
        jogadores.add(new JogadorBot("maria", baralho.getSeisCartas()));
        jogadores.add(new JogadorBot("marcos", baralho.getSeisCartas()));
    }

    public void iniciarPartida(){
        boolean cont = true;
        while(cont){
           cont = rodada();

        }
    }

    public boolean rodada(){

        for (Jogador jogadore : jogadores) {

            System.out.println("Messa = " + messa.toString());
            Jogador jg = jogadore;
            Carta carta = jg.jogada(messa);

            if (carta == null) {
                jg.comprarCarta(baralho.getUmaCarta());

            } else {
                messa = carta;
            }

            if (jg.vitoria()) {
                System.out.println("Vitoria: " + jg.getName());
                return false;
            }


        }
        return true;

    }

}
