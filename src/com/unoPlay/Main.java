package com.unoPlay;

import com.unoPlay.entity.Partida;
import com.unoPlay.entity.View;


public class Main {
    public static void main(String[] args) {


        Partida partida = new Partida(View.inputString("nome: "));
        partida.iniciarPartida();
    }
}
