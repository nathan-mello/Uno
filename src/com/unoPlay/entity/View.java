package com.unoPlay.entity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputInt(String str){
        System.out.println(str);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Valor Digita invalido, tente novamente.");
            return inputInt(str);
        }
    }

    public static String inputString(String str){
        System.out.println(str);
        return scanner.next();
    }

    public static Carta jogada(ArrayList<Carta> opcoes){

        int opcao = 1;

        String retorno = "Escolha sua carta: \n";
        for (Carta str: opcoes) {
            retorno += opcao + " - " + str.toString() + "\n";
            opcao += 1;

        }
        retorno += opcao + " - Compre uma carta\n";
        retorno += "-----------------------------\n";

        int index = inputInt(retorno)-1;

        if(index>=0 && index<opcoes.size()){
            return opcoes.get(index);
        }else if(index==opcoes.size()){
            return null;
        }else{
            System.out.println("Opção invalida, tente novamente.\n");
            return jogada(opcoes);
        }
    }

    public static String trocaCor(){
        int number = inputInt("Escolha cor:\n 1 - [vermelho]\n 2 - [verde]\n 3 - [azul]\n 4 - [amarelo]\n");
        if(number ==1){
            return "Vermelho";
        }else if(number ==2){
            return "Amarelo";
        }else if(number ==3){
            return "Azul";
        } else if (number == 4) {
            return "Azul";
        }else{
            println("opcão invalida tente novamente");
            return trocaCor();
        }
    }

    public static void println(String string){
        System.out.println(string);
    }

}
