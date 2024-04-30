package br.com.fiap.motos.dto.response;

import lombok.Builder;

@Builder
public record FabricanteResponse(
        Long id,
        String nome,
        String nomeFantasia
) {
}
