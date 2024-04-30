package br.com.fiap.motos.dto.response;

import lombok.Builder;

@Builder
public record CaracteristicaResponse(
        String nome,
        String descricao,
        Long id,
        VeiculoResponse veiculo
) {
}
