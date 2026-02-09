package com.motocaparts.domain.model;

import com.motocaparts.domain.model.vo.Email;

public class Usuario {
    private Email email;

    public Usuario(Email email) {
        if (email == null) {
            throw new IllegalArgumentException("O E-mail, é obrigatório para criar um usuário");
        }
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
