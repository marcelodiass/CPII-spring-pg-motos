package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record FabricanteRequest(
        @NotNull(message = "O nome deve ser informado!")
        String nome,

        @NotNull(message = "O nome de fantasia deve ser informado!")
        String nomeFantasia
) {
}
