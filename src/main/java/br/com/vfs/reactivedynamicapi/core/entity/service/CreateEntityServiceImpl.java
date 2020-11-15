package br.com.vfs.reactivedynamicapi.core.entity.service;

import br.com.vfs.reactivedynamicapi.core.entity.integration.EntityIntegration;
import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class CreateEntityServiceImpl implements CreateEntityService {

    private final EntityIntegration entityIntegration;

    @Override
    public Mono<Entity> apply(final Mono<CreateEntity> createEntity) {
        //TODO salvando sem validacao
        return createEntity.map(CreateEntity::entity)
                .as(entityIntegration::save);
    }
}
