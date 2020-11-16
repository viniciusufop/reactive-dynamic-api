package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

class EntityNamePatternValidatorTest {

    private final EntityNamePatternValidator validator = new EntityNamePatternValidator();

    @Test
    void should_success_with_entity_with_valid_name(){
        final Entity entity = ofEntity("test");
        final Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .map(e -> e.equals(entity))
                .doOnSuccess(Assertions::assertTrue)
                .doOnError(Assertions::assertNotNull);
    }

    @Test
    void should_exception_entity_with_invalid_name(){
        final Entity entity = ofEntity("test##");
        Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .doOnSuccess(Assertions::assertNotNull)
                .doOnError(Assertions::assertNull);
    }

    @Test
    void should_exception_entity_with_null_name(){
        final Entity entity = ofEntity(null);
        Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .doOnSuccess(Assertions::assertNotNull)
                .doOnError(Assertions::assertNull);
    }

    private Entity ofEntity(String name) {
        return new Entity(UUID.randomUUID().toString(), name, true, List.of());
    }

}
