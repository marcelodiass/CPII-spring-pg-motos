package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AcessorioRequest(
        @NotNull(message = "O nome deve ser informado!")
        String nome,

        @Positive(message = "O preço deve ser um número positivo!")
        @NotNull(message = "O preço deve ser informado!")
        Double preco
) {
}
