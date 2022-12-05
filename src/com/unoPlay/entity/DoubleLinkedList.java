package com.unoPlay.entity;

import java.util.ArrayList;
import java.util.Iterator;

public class DoubleLinkedList {

    private Jogador ponteiro;
    private boolean ordem;

    public DoubleLinkedList(ArrayList<Jogador> array) {
        this.ponteiro = null;
        this.ordem = true;

        Iterator<Jogador> iterator = array.iterator();

        Jogador ultimoJogador = null;
        while (iterator.hasNext()){
            Jogador atual = iterator.next();
            if(ponteiro == null){
                ponteiro = atual;
                ultimoJogador = atual;
            }else{
                ultimoJogador.setJogadorNext(atual);
                atual.setJogadorPrevious(ultimoJogador);
                ultimoJogador = atual;
            }
        }
        ponteiro.setJogadorPrevious(ultimoJogador);
        ultimoJogador.setJogadorNext(ponteiro);
    }

    public Jogador getPonteiro() {
        return ponteiro;
    }

    public void setPonteiro(Jogador ponteiro) {
        this.ponteiro = ponteiro;
    }

    public boolean isOrdem() {
        return ordem;
    }

    public void inverteOrdem(){
        ordem = !ordem;
    }

    public void nextJogador(){
        if(ordem){
            setPonteiro(ponteiro.getJogadorNext());
        }else{
            setPonteiro(ponteiro.getJogadorPrevious());
        }
    }

    @Override
    public String toString() {
        String retorno = "";
        int cont = 0;
        while(cont<5){
            nextJogador();
            retorno += ponteiro.getJogadorPrevious().getName() +"-->"+ ponteiro.getName()  +"-->"+ponteiro.getJogadorNext().getName()+"\n";
            cont += 1;
        }
        return retorno;
    }
}