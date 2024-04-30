package br.com.fiap.motos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_LOJA")
public class Loja {
    @Id
    @SequenceGenerator(name = "SQ_LOJA", sequenceName = "SQ_LOJA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOJA")
    @Column(name = "ID_LOJA")
    private Long id;

    @Column(name = "NM_LOJA")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_LOJA_VEICULO",
            joinColumns = @JoinColumn(name = "ID_LOJA",
                    referencedColumnName = "ID_LOJA",
                    foreignKey = @ForeignKey(name = "FK_LOJA_VEICULO")),
            inverseJoinColumns = @JoinColumn(name = "ID_VEICULO",
                    referencedColumnName = "ID_VEICULO",
                    foreignKey = @ForeignKey(name = "FK_VEICULO_LOJA")),
            uniqueConstraints = @UniqueConstraint(name = "UK_LOJA_VEICULO", columnNames = {"ID_VEICULO"})
    )
    private Set<Veiculo> veiculosComercializados = new LinkedHashSet<>();

}
