package br.com.vfs.reactivedynamicapi.core.entity.integration;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EntityIntegration {

    Flux<Entity> findAll();

    Mono<Entity> save(final Mono<Entity> entity);
}
