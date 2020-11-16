package br.com.vfs.reactivedynamicapi.core.entity.service;


import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public interface CreateEntityService extends Function<Mono<CreateEntity>, Mono<Entity>> {
}
