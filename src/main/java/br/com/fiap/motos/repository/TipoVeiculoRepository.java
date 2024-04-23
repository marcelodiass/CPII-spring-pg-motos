package br.com.fiap.motos.repository;

import br.com.fiap.motos.entity.TipoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVeiculoRepository extends JpaRepository<TipoVeiculo, Long> {
}
