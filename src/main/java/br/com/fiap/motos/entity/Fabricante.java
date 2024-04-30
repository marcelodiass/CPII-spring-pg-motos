package br.com.fiap.motos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_FABRICANTE")
public class Fabricante {
    @Id
    @SequenceGenerator(name = "SQ_FABRICANTE", sequenceName = "SQ_FABRICANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FABRICANTE")
    @Column(name = "ID_FABRICANTE")
    private Long id;

    @Column(name = "NM_FABRICANTE")
    private String nome;

    @Column(name = "NM_FANTASIA_FABRICANTE")
    private String nomeFantasia;



}
