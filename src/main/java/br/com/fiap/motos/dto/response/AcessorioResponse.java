package br.com.fiap.motos.dto.response;

import lombok.Builder;

@Builder
public record AcessorioResponse(
        String nome,
        Double preco,
        Long id
) {
}
