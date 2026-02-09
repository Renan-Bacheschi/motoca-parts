package com.motocaparts.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Peca {
    private UUID id;
    private String sku;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;

    public Peca(UUID id, String sku, String nome, BigDecimal preco, Integer quantidadeEstoque) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Regra de Negocio (Rich Domain Model)
    public void debitarEstoque(Integer quantidade) {
        if (this.quantidadeEstoque < quantidade) {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente para: " + this.nome);
        }
        this.quantidadeEstoque -= quantidade;
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getSku() {return sku;}

    public void setSku(String sku) {this.sku = sku;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public BigDecimal getPreco() {return preco;}

    public void setPreco(BigDecimal preco) {this.preco = preco;}

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}