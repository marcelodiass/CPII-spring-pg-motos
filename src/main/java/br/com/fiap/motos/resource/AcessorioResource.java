package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.AcessorioRequest;
import br.com.fiap.motos.dto.response.AcessorioResponse;
import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.service.AcessorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping(value = "/acessorio")
public class AcessorioResource implements ResourceDTO<Acessorio, AcessorioRequest, AcessorioResponse>{

    @Autowired
    AcessorioService service;

    @GetMapping
    public ResponseEntity<Collection<AcessorioResponse>> findAll(
            @RequestParam(name="nome", required = false) String nome,
            @RequestParam(name="preco", required = false) Double preco
    ) {
        var acessorio = Acessorio.builder()
                .nome(nome)
                .preco(preco)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();
        Example<Acessorio> example = Example.of( acessorio , matcher );

        var encontrados = service.findAll( example );

        if (encontrados.isEmpty()) return ResponseEntity.noContent().build();

        var resposta = encontrados.stream()
                .map( service::toResponse )
                .toList();

        return ResponseEntity.ok( resposta );
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AcessorioResponse> findById(@PathVariable  Long id) {
        var encontrado = service.findById( id );
        if (encontrado == null) return ResponseEntity.notFound().build();
        var resposta = service.toResponse( encontrado );
        return ResponseEntity.ok( resposta );
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<AcessorioResponse> save(@RequestBody @Valid AcessorioRequest r) {
        var entity = service.toEntity( r );
        var saved = service.save( entity );
        var resposta = service.toResponse( saved );

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path( "/{id}" )
                .buildAndExpand( saved.getId() )
                .toUri();

        return ResponseEntity.created( uri ).body( resposta );
    }
}
