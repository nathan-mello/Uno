package com.unoPlay.entity;


public class Carta {
    private Integer number;
    private String cor;

    public Carta( Integer number, String cor) {
        this.number = number;
        this.cor = cor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    @Override
    public String toString() {
        return "[ " + number + " : " + cor + " ]";

    }
}
