package br.com.fiap.motos.service;


import org.springframework.data.domain.Example;

import java.util.Collection;

/**
 * @param <Entity>    Entity
 * @param <Request>   RequestDTO
 * @param <Response>> ResponseDTO
 */
public interface ServiceDTO<Entity, Request, Response> {


    public Collection<Entity> findAll(Example<Entity> example);


    public Entity findById(Long id);


    public Entity save(Entity e);

    /**
     * Transforma o RequestDTO em Entidade
     *
     * @param dto é um DTO de requisição ( RequestDTO )
     * @return uma Entidade
     */
    public Entity toEntity(Request dto);

    /**
     * Transforma uma Entidade em um DTO de Resposta (ResponseDTO)
     *
     * @param e
     * @return
     */
    public Response toResponse(Entity e);


}
