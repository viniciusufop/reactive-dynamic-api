package br.com.vfs.reactivedynamicapi.core.entity.service;

import br.com.vfs.reactivedynamicapi.core.entity.integration.EntityIntegration;
import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.core.entity.validator.CreateEntityValidator;
import br.com.vfs.reactivedynamicapi.core.entity.validator.EntityNameValidator;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
class CreateEntityServiceImpl implements CreateEntityService {

    private final EntityIntegration entityIntegration;
    private final Collection<CreateEntityValidator> validators;
    @Override
    public Mono<Entity> apply(final Mono<CreateEntity> createEntity) {
//        Mono<Entity> map = createEntity
//                .map(CreateEntity::entity);
//        Mono<Entity> map2 = createEntity
//                .map(CreateEntity::entity);
//        return Mono.zip(
//                map
//                    .flatMap(entity -> EntityNameValidator.apply(entity, entityIntegration.findAll())),
//                map2
//                        .as(this::executeValidators))
//                .flatMap(objects -> entityIntegration.save(Mono.just(objects.getT1())))
//                .doOnSuccess(entity -> log.info("success in save entity {}", entity.getName()))
//                .doOnError(exception -> log.error("error in save entity", exception));

        return createEntity
                .map(CreateEntity::entity)
                .flatMap(entity -> EntityNameValidator.apply(entity, entityIntegration.findAll()))
                .as(this::executeValidators)
                .as(entityIntegration::save)
                .doOnSuccess(entity -> log.info("success in save entity {}", entity.getName()))
                .doOnError(exception -> log.error("error in save entity", exception));
    }

    private Mono<Entity> executeValidators(final Mono<Entity> entity) {
        return Mono.justOrEmpty(
                validators.stream()
                .reduce((validatorOne, validatorTwo) -> validatorOne.compose(validatorTwo)))
                .flatMap(validator -> validator.apply(entity))
                .switchIfEmpty(entity);
    }
}