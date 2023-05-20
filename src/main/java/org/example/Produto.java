package org.example;

import java.util.Observable;

public class Produto extends Observable {
    private Integer valor;
    private String categoria;
    private String nomeLoja;
    private String nomeProduto;

    public Produto(Integer valor, String categoria, String nomeLoja, String nomeProduto) {
        this.valor = valor;
        this.categoria = categoria;
        this.nomeLoja = nomeLoja;
        this.nomeProduto = nomeProduto;
    }

    public void diminuirPreco() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Valor=" + valor +
                ", categoria=" + categoria +
                ", nomeLoja='" + nomeLoja + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                '}';
    }
}
