package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CaracteristicaRequest(
        @Valid @NotNull(message = "É necessário informar o veículo!")
        AbstractRequest veiculo,

        @NotNull(message = "O nome deve ser informado!")
        String nome,

        @NotNull(message = "A descrição deve ser informada!")
        String descricao
) {
}
