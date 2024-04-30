package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record TipoVeiculoRequest(
        @NotNull(message = "O nome deve ser informado!")
        String nome
) {
}
