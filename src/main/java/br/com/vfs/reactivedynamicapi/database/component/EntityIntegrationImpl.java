package br.com.vfs.reactivedynamicapi.database.component;

import br.com.vfs.reactivedynamicapi.core.entity.integration.EntityIntegration;
import br.com.vfs.reactivedynamicapi.database.model.EntityDataBase;
import br.com.vfs.reactivedynamicapi.database.repository.EntityRepository;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class EntityIntegrationImpl implements EntityIntegration {

    private final EntityRepository repository;

    @Override
    public Flux<Entity> findAll() {
        return repository.findAll()
                .map(EntityDataBase::toModel);
    }

    @Override
    public Mono<Entity> save(Mono<Entity> entity) {
        return entity.map(EntityDataBase::new)
                .flatMap(repository::save)
                .map(EntityDataBase::toModel);
    }
}
