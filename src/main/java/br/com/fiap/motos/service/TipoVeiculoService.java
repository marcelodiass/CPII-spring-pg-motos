package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.TipoVeiculoRequest;
import br.com.fiap.motos.dto.response.TipoVeiculoResponse;
import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.repository.TipoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVeiculoService implements ServiceDTO<TipoVeiculo, TipoVeiculoRequest, TipoVeiculoResponse>{
    @Autowired
    private TipoVeiculoRepository repo;

    @Override
    public List<TipoVeiculo> findAll(Example<TipoVeiculo> example) {
        return repo.findAll(example);
    }

    @Override
    public TipoVeiculo findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public TipoVeiculo save(TipoVeiculo e) {
        return repo.save(e);
    }

    @Override
    public TipoVeiculo toEntity(TipoVeiculoRequest r) {
        return TipoVeiculo.builder()
                .nome(r.nome())
                .build();
    }

    @Override
    public TipoVeiculoResponse toResponse(TipoVeiculo e) {
        return TipoVeiculoResponse.builder()
                .nome(e.getNome())
                .id(e.getId())
                .build();
    }
}
