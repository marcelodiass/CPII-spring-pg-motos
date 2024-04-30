package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.VeiculoRequest;
import br.com.fiap.motos.dto.response.VeiculoResponse;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse>{
    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @Autowired
    private FabricanteService fabricanteService;


    @Override
    public List<Veiculo> findAll(Example<Veiculo> example) {
        return repo.findAll(example);
    }

    @Override
    public Veiculo findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Veiculo save(Veiculo e) {
        return repo.save(e);
    }

    @Override
    public Veiculo toEntity(VeiculoRequest r) {
        var tipoVeiculo = tipoVeiculoService.findById(r.tipo().id());
        var fabricante = fabricanteService.findById(r.fabricante().id());

        return Veiculo.builder()
                .cor(r.cor())
                .nome(r.nome())
                .anoDeFabricacao(r.anoDeFabricacao())
                .cilindradas(r.cilindradas())
                .preco(r.preco())
                .tipo(tipoVeiculo)
                .fabricante(fabricante)
                .palavraDeEfeito(r.palavraDeEfeito())
                .modelo(r.modelo())
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo e) {
        var tipoVeiculoResponse = tipoVeiculoService.toResponse(e.getTipo());

        var fabricanteResponse = fabricanteService.toResponse(e.getFabricante());


        return VeiculoResponse.builder()
                .id(e.getId())
                .cor(e.getCor())
                .modelo(e.getModelo())
                .preco(e.getPreco())
                .anoDeFabricacao(e.getAnoDeFabricacao())
                .tipo(tipoVeiculoResponse)
                .cilindradas(e.getCilindradas())
                .nome(e.getNome())
                .palavraDeEfeito(e.getPalavraDeEfeito())
                .fabricante(fabricanteResponse)
                .build();
    }
}
