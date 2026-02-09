package com.motocaparts.domain.model.vo;

import java.util.regex.Pattern;

public class Email {
    private final String value;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Campo e-mail nao pode ser vazio ou nulo");
        } if (!Pattern.compile(EMAIL_REGEX).matcher(value).matches()) {
            throw new IllegalArgumentException("Formato de e-mail inválido!");
        } this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email  email = (Email) o;
        return java.util.Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

}