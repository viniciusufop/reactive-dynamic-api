package br.com.vfs.reactivedynamicapi.core.entity.service;


import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import reactor.core.publisher.Mono;

public interface CreateEntityService {

    Mono<Entity> apply(final Mono<CreateEntity> createEntity);
}
