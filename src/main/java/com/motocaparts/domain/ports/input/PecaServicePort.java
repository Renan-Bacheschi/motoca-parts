package com.motocaparts.domain.ports.input;

import com.motocaparts.domain.model.Peca;

import java.util.UUID;

public interface PecaServicePort {
    Peca criarPeca(Peca peca);

    void debitarEstoque(UUID id, Integer quantidade);
}