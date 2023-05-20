package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveNotificarUmCliente() {
        Produto produto = new Produto(1500, "Celular", "Americanas", "Xiaomi a2 lite");
        Cliente cliente1 = new Cliente("Cliente 1");
        cliente1.alertar(produto);
        produto.diminuirPreco();
        assertEquals("Cliente 1, produto em queda: Produto{Valor=1500, categoria=Celular, nomeLoja='Americanas', nomeProduto='Xiaomi a2 lite'}", cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Produto produto = new Produto(1500, "Celular", "Americanas", "Xiaomi a2 lite");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.alertar(produto);
        cliente2.alertar(produto);
        produto.diminuirPreco();
        assertEquals("Cliente 1, produto em queda: Produto{Valor=1500, categoria=Celular, nomeLoja='Americanas', nomeProduto='Xiaomi a2 lite'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, produto em queda: Produto{Valor=1500, categoria=Celular, nomeLoja='Americanas', nomeProduto='Xiaomi a2 lite'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Produto produto = new Produto(1500, "Celular", "Americanas", "Xiaomi a2 lite");
        Cliente cliente = new Cliente("Cliente 1");
        produto.diminuirPreco();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteProdutoA() {
        Produto produtoA = new Produto(1500, "Celular", "Americanas", "Xiaomi a2 lite");
        Produto produtoB = new Produto(1500, "TV", "Magazine", "Samsung 42 Polegadas");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.alertar(produtoA);
        cliente2.alertar(produtoB);
        produtoA.diminuirPreco();
        assertEquals("Cliente 1, produto em queda: Produto{Valor=1500, categoria=Celular, nomeLoja='Americanas', nomeProduto='Xiaomi a2 lite'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }

}