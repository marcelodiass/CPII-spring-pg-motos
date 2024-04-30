package br.com.fiap.motos.dto.response;

import lombok.Builder;

import java.time.Year;

@Builder
public record VeiculoResponse(
        String modelo,
        Year anoDeFabricacao,
        TipoVeiculoResponse tipo,
        String cor,
        FabricanteResponse fabricante,
        Double preco,
        String nome,
        String palavraDeEfeito,
        Short cilindradas,
        Long id

) {
}
