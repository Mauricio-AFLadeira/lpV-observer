package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void alertar(Produto produto) {
        produto.addObserver(this);
    }

    public void update(Observable produto, Object arg1) {
        this.ultimaNotificacao = this.nome + ", produto em queda: " + produto.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
