package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.model.entity.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static br.com.vfs.reactivedynamicapi.model.entity.FieldType.TEXT;

public class EntityContainsFieldValidatorTest {

    private final EntityContainsFieldValidator validator = new EntityContainsFieldValidator();

    @Test
    void should_success_with_entity_contains_fields(){
        final Entity entity = ofEntity(List.of(new Field("test", TEXT)));
        final Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .map(e -> e.equals(entity))
                .doOnSuccess(Assertions::assertTrue)
                .doOnError(Assertions::assertNotNull);
    }

    @Test
    void should_exception_entity_not_contains_fields(){
        final Entity entity = ofEntity(List.of());
        Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .doOnSuccess(Assertions::assertNotNull)
                .doOnError(Assertions::assertNull);
    }

    private Entity ofEntity(final List<Field> fields) {
        return new Entity(UUID.randomUUID().toString(), "test", true, fields);
    }

}
