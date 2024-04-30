package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.FabricanteRequest;
import br.com.fiap.motos.dto.response.FabricanteResponse;
import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService implements ServiceDTO<Fabricante, FabricanteRequest, FabricanteResponse> {

    @Autowired
    private FabricanteRepository repo;

    @Override
    public List<Fabricante> findAll(Example<Fabricante> example) {
        return repo.findAll(example);
    }

    @Override
    public Fabricante findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Fabricante save(Fabricante e) {
        return repo.save(e);
    }

    @Override
    public Fabricante toEntity(FabricanteRequest r) {
        return Fabricante.builder()
                .nome(r.nome())
                .nomeFantasia(r.nomeFantasia())
                .build();
    }

    @Override
    public FabricanteResponse toResponse(Fabricante e) {
        return FabricanteResponse.builder()
                .id(e.getId())
                .nomeFantasia(e.getNomeFantasia())
                .nome(e.getNome())
                .build();
    }
}
