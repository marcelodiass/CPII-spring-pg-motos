package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.AcessorioRequest;
import br.com.fiap.motos.dto.request.VeiculoRequest;
import br.com.fiap.motos.dto.response.AcessorioResponse;
import br.com.fiap.motos.dto.response.VeiculoResponse;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.service.AcessorioService;
import br.com.fiap.motos.service.FabricanteService;
import br.com.fiap.motos.service.TipoVeiculoService;
import br.com.fiap.motos.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Year;
import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource implements ResourceDTO<Veiculo, VeiculoRequest, VeiculoResponse>{

    @Autowired
    private VeiculoService service;

    @Autowired
    private AcessorioService acessorioService;

    @Autowired
    private FabricanteService fabricanteService;

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @GetMapping
    public ResponseEntity<Collection<VeiculoResponse>> findAll (
            @RequestParam(name="preco", required = false) Double preco,
            @RequestParam(name="modelo", required = false) String modelo,
            @RequestParam(name="anoDeFabricacao", required = false) Year anoDeFabricacao,
            @RequestParam(name="nome", required = false) String nome,
            @RequestParam(name="tipo.id", required = false) Long idTipo,
            @RequestParam(name = "fabricante.id", required = false) Long idFabricante,
            @RequestParam(name="cor", required = false) String cor,
            @RequestParam(name="cilindradas", required = false) Short cilindradas
    ) {
        var fabricante = Objects.nonNull(idFabricante) ? fabricanteService.findById(idFabricante) : null;
        var tipoVeiculo = Objects.nonNull(idTipo) ? tipoVeiculoService.findById(idTipo) : null;
        var veiculo = Veiculo.builder()
                .anoDeFabricacao(anoDeFabricacao)
                .cor(cor)
                .nome(nome)
                .preco(preco)
                .cilindradas(cilindradas)
                .modelo(modelo)
                .fabricante(fabricante)
                .tipo(tipoVeiculo)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();
        Example<Veiculo> example = Example.of(veiculo, matcher);
        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.noContent().build();

        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);
        if (encontrado == null) return ResponseEntity.notFound().build();

        var response = service.toResponse(encontrado);
        return ResponseEntity.ok(response);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<VeiculoResponse> save(@RequestBody @Valid VeiculoRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);
        var resposta = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path( "/{id}" )
                .buildAndExpand( saved.getId() )
                .toUri();

        return ResponseEntity.created( uri ).body( resposta );
    }

    @Transactional
    @PostMapping(value="/{id}/acessorios")
    public ResponseEntity<VeiculoResponse> saveAcessorio(@PathVariable Long id, @RequestBody @Valid AcessorioRequest r){
        var veiculo = service.findById( id );
        if (veiculo == null) return ResponseEntity.notFound().build();

        var acessorio = acessorioService.toEntity( r );
        var acessorios = veiculo.getAcessorios();
        acessorios.add( acessorio );
        veiculo.setAcessorios(acessorios);

        var saved = service.save( veiculo );
        var resposta = service.toResponse( saved );


        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path( "/{id}" )
                .buildAndExpand( saved.getId() )
                .toUri();

        return ResponseEntity.created( uri ).body( resposta );
    }

    @Transactional
    @GetMapping(value="/{id}/acessorios")
    public ResponseEntity<Collection<AcessorioResponse>> findAcessorios(@PathVariable Long id)
    {
        var veiculo = service.findById( id );
        if (veiculo == null) return ResponseEntity.notFound().build();

        var acessorios = veiculo.getAcessorios();
        var resposta = acessorios.stream()
                .map( acessorioService::toResponse )
                .toList();

        if(resposta.isEmpty()) return ResponseEntity.noContent().build();


        return ResponseEntity.ok( resposta );
    }
}
