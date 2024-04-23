package br.com.fiap.motos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Veiculo {

    private Long id;

    private String nome;

    private Year anoDeFabricacao;

    private String cor;

    private Double preco;

    private Short cilindradas;

    private String modelo;

    //15 digitos
    private String palavraDeEfeito;

    private Fabricante fabricante;

    private TipoVeiculo tipo;

    private Set<Acessorio> acessorios = new LinkedHashSet<>();

}
