package com.unoPlay.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Baralho {
    private final ArrayList<Carta> baralho;
    private final Random gerador = new Random();

    public Baralho() {
        this.baralho = new ArrayList<>();
    }

    public Carta criarFirstCartas() {
        List<String> cores = Arrays.asList("Vermelho", "Amarelo", "Azul", "Verde");

        for (String cor : cores) {
            for (int i = 1; i < 10; i++) {
                Carta carta = new Carta(i, cor);
                baralho.add(carta);
                baralho.add(carta);

            }
            Carta carta = new Carta(0, cor);
            baralho.add(carta);

        }

        Carta carta = baralho.remove(gerador.nextInt(baralho.size()));
        criarCartasEspeciais();
        return carta;
    }

    public void criarCartas() {
        List<String> cores = Arrays.asList("Vermelho", "Amarelo", "Azul", "Verde");

        for (String cor : cores) {
            for (int i = 1; i < 10; i++) {
                Carta carta = new Carta(i, cor);
                baralho.add(carta);
                baralho.add(carta);

            }
            Carta carta = new Carta(0, cor);
            baralho.add(carta);

        }

        criarCartasEspeciais();
    }

    public void criarCartasEspeciais(){
        List<String> cores = Arrays.asList("Vermelho", "Amarelo", "Azul", "Verde");

        for (String cor : cores) {
            CartaEspecial cartaDeBloqueio = new CartaEspecial(13, cor, "Carta de bloqueio");
            baralho.add(cartaDeBloqueio);
            baralho.add(cartaDeBloqueio);
            CartaEspecial cartaDeInverter = new CartaEspecial(13, cor, "Inverte ordem");
            baralho.add(cartaDeInverter);
            baralho.add(cartaDeInverter);
            CartaEspecial cartaMaisTwo = new CartaEspecial(13, cor, "compra +2");
            baralho.add(cartaMaisTwo);
            baralho.add(cartaMaisTwo);
            }

        CartaEspecial carta1 = new CartaEspecial(14, "preto", "Troca de cor");
        baralho.add(carta1);

        CartaEspecial carta2 = new CartaEspecial(14, "preto", "mais quatro");
        baralho.add(carta2);


    }

    public Carta getUmaCarta(){

        if(baralho.isEmpty()){
            criarCartas();
        }
        int index = gerador.nextInt(baralho.size());

        return baralho.remove(index);


    }

    public ArrayList<Carta> getSeisCartas(){
        ArrayList<Carta> cartas = new ArrayList<>();

        cartas.add(getUmaCarta());
        cartas.add(getUmaCarta());
        cartas.add(getUmaCarta());
        cartas.add(getUmaCarta());
        cartas.add(getUmaCarta());
        cartas.add(getUmaCarta());

        return cartas;
    }
}

