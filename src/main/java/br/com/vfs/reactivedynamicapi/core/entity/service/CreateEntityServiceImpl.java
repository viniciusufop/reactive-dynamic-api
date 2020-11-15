package br.com.vfs.reactivedynamicapi.core.entity.service;

import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.core.entity.validator.CreateEntityValidator;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Service
@RequiredArgsConstructor
class CreateEntityServiceImpl implements CreateEntityService {

    private final Collection<CreateEntityValidator> validators;
    @Override
    public Mono<Entity> apply(final Mono<CreateEntity> createEntity) {
        //listar todas as entidades
        return Mono.empty();
    }
}
