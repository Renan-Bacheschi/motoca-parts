package com.motocaparts.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PecaTest {

    @Test
    void shouldDebitStockSuccessfully() {
        Peca peca = new Peca(UUID.randomUUID(), "PNEU-01", "Pneu Michelin", new BigDecimal("450.00"), 10);

        // Regra de negocio
        peca.debitarEstoque(7);

        // Verifica
        assertEquals(3, peca.getQuantidadeEstoque());
        System.out.println("Sucesso! Estoque atual da peça " + peca.getNome() + ": " + peca.getQuantidadeEstoque());
    }

    @Test
    void shouldThrowExceptionWhenStockIsInsufficient() {
        Peca peca = new Peca(UUID.randomUUID(), "PNEU-01", "Pneu Michelin", new BigDecimal("450.00"), 5);

        // Verifica exceção
        assertThrows(IllegalArgumentException.class, () -> {
            peca.debitarEstoque(7);
        });
    }
}