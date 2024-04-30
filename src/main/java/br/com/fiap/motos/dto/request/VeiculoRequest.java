package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Year;

public record VeiculoRequest(
        @Valid @NotNull(message = "O tipo deve ser informado!")
        AbstractRequest tipo,

        @Valid @NotNull(message = "O fabricante deve ser informado!")
        AbstractRequest fabricante,

        @Positive(message = "O preço deve ser um número positivo!")
        @NotNull(message = "O preço deve ser informado!")
        Double preco,

        @NotNull(message = "O modelo deve ser informado!")
        String modelo,

        @NotNull(message = "O ano deve ser informado!")
        Year anoDeFabricacao,

        @NotNull(message = "O nome deve ser informado!")
        String nome,

        @NotNull(message = "A cor deve ser informada!")
        String cor,

        @NotNull(message = "A palavra de efeito deve ser informada!")
        String palavraDeEfeito,

        @Positive(message = "As cilindradas devem ser um número positivo")
        @NotNull(message = "As cilindradas devem ser informadas!")
        Short cilindradas
) {
}
