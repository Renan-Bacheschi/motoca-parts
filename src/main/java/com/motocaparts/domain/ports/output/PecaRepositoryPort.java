package com.motocaparts.domain.ports.output;

import com.motocaparts.domain.model.Peca;

import java.util.Optional;
import java.util.UUID;

public interface PecaRepositoryPort {
    Peca salvar(Peca peca);

    Optional<Peca> buscarPorId(UUID id);

    Optional<Peca> buscarPorSku(String sku);
}