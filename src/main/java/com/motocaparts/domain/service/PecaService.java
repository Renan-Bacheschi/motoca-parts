package com.motocaparts.domain.service;

import com.motocaparts.domain.model.Peca;
import com.motocaparts.domain.ports.input.PecaServicePort;
import com.motocaparts.domain.ports.output.PecaRepositoryPort;

import java.util.UUID;

public class PecaService implements PecaServicePort {

    private final PecaRepositoryPort repository;

    public PecaService(PecaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Peca criarPeca(Peca peca) {
        return repository.salvar(peca);
    }

    @Override
    public void debitarEstoque(UUID id, Integer quantidade) {
        // busca a peca pela porta de saída
        Peca peca = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada no MotocaParts"));

        // regra
        peca.debitarEstoque(quantidade);

        // salvar estado no banco
        repository.salvar(peca);


    }


}