package br.com.fiap.motos.dto.response;

import lombok.Builder;

@Builder
public record TipoVeiculoResponse(
        Long id,
        String nome
) {
}
