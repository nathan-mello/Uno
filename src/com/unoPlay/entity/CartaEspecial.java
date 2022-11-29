package com.unoPlay.entity;

public class CartaEspecial extends Carta{
    private String name;
    Integer number;
    String cor;

    public CartaEspecial(Integer number, String cor, String name) {
        super(number, cor);
        this.name = name;
        this.number = number;
        this.cor = cor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "[ " + cor + " : " + name + " ]";
    }
}
