package com.unoPlay.entity;

import java.util.ArrayList;

public class Partida {
    private final Baralho baralho = new Baralho();
    private final DoubleLinkedList jogadores;
    private Carta messa;

    public Partida(String name) {
        this.messa = baralho.criarFirstCartas();
        System.out.println(baralho.size());
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

                switch (messa.getNumber()) {
                    case 13:
                        jogadores.nextJogador();
                        jg = jogadores.getPonteiro();
                        View.println("Jogador " + jg.getName() + "foi bloqueado");
                        break;
                    case 14:
                        jogadores.inverteOrdem();
                        View.println("Ordem invertida");
                        break;
                    case 15:
                        jogadores.nextJogador();
                        jg = jogadores.getPonteiro();
                        View.println("Jogador " + jg.getName() + "compre mais duas cartas");
                        jg.comprarCarta(baralho.getUmaCarta());
                        jg.comprarCarta(baralho.getUmaCarta());
                        break;
                    case 16:
                        messa.setCor(jg.trocaCor());
                        break;
                    case 17:
                        messa.setCor(jg.trocaCor());
                        jogadores.nextJogador();
                        jg = jogadores.getPonteiro();
                        View.println("Jogador " + jg.getName() + "compre mais quatro cartas");
                        jg.comprarCarta(baralho.getUmaCarta());
                        jg.comprarCarta(baralho.getUmaCarta());
                        jg.comprarCarta(baralho.getUmaCarta());
                        jg.comprarCarta(baralho.getUmaCarta());
                        break;

                }
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
