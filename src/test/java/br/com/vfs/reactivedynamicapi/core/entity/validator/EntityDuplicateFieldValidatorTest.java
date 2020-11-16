package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.model.entity.Field;
import br.com.vfs.reactivedynamicapi.model.entity.FieldType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static br.com.vfs.reactivedynamicapi.model.entity.FieldType.TEXT;

class EntityDuplicateFieldValidatorTest {

    private final EntityDuplicateFieldValidator validator = new EntityDuplicateFieldValidator();

    @Test
    void should_success_with_entity_not_duplicate_field(){
        final Entity entity = ofEntity(List.of(ofField("test"), ofField("testTwo"), ofField("testThree")));
        final Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .map(e -> e.equals(entity))
                .doOnSuccess(Assertions::assertTrue)
                .doOnError(Assertions::assertNotNull);
    }

    @Test
    void should_exception_with_entity_duplicate_field(){
        final Entity entity = ofEntity(List.of(ofField("test"), ofField("testTwo"), ofField("test")));
        Mono<Entity> apply = validator.apply(Mono.just(entity));
        apply
                .doOnSuccess(Assertions::assertNotNull)
                .doOnError(Assertions::assertNull);
    }

    private Entity ofEntity(final List<Field> fields) {
        return new Entity(UUID.randomUUID().toString(), "test", true, fields);
    }

    private Field ofField(final String name) {
        return new Field(name, TEXT);
    }

}
