package com.unoPlay.entity;

import java.util.ArrayList;

public class JogadorBot extends Jogador{
    ArrayList<Carta> cartas;
    String name;
    Jogador jogadorNext;
    Jogador jogadorPrevious;

    public JogadorBot(String name, ArrayList<Carta> cartas) {
        super(name, cartas);
        this.cartas = cartas;
        this.name = name;
        this.jogadorNext = null;
        this.jogadorPrevious = null;
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
    @Override
    public void comprarCarta( Carta carta){
        View.println("O jogador "+ name+ " comprou uma carta");
        cartas.add(carta);
    }
    @Override
    public String trocaCor() {
        int red = 0;
        int green = 0;
        int blue = 0;
        int yellow = 0;
        for (Carta carta : cartas) {
            switch (carta.getCor()) {
                case "Vermelho":
                    red++;
                    break;
                case "Amarelo":
                    yellow++;
                    break;
                case "Azul":
                    blue++;
                    break;
                case "Verde":
                    green++;
                    break;

            }

        }
        String cor = "";
        if (green >= red && green >= blue && green >= yellow) {
            cor = "Verde";
        } else if (red >= green && red >= blue && red >= yellow) {
            cor = "Vermelho";
        } else if (blue >= red && blue >= green && blue >= yellow) {
            cor = "Azul";
        } else {
            cor = "Amarelo";
        }

        View.println("O jogador " + name + "trocou de cor para " + cor);
        return cor;

    }

    public int size(){
        return cartas.size();
    }

}
