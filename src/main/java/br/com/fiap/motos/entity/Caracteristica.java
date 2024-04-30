package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_CARACTERISTICA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CARACTERISTICA_NOME", columnNames = {"NM_CARACTERISTICA", "VEICULO"})
})
public class Caracteristica {

    @Id
    @SequenceGenerator(name = "SQ_CARACTERISTICA", sequenceName = "SQ_CARACTERISTICA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARACTERISTICA")
    @Column(name = "ID_CARACTERISTICA")
    private Long id;

    //30 digitos
    @Column(name = "NM_CARACTERISTICA", length = 30)
    private String nome;

    //20 digitos
    @Column(name = "DESC_CARACTERISTICA", length = 20)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "VEICULO",
            referencedColumnName = "ID_VEICULO",
            foreignKey = @ForeignKey(
                    name = "FK_VEICULO_CARACTERISTICA"
            )
    )
    private Veiculo veiculo;


}
