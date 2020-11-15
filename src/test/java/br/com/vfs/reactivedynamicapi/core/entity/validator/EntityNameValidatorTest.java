package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class EntityNameValidatorTest {

    @Test
    void should_success_with_entity_name_not_exist_in_collection(){
        final Entity one = ofEntity("test");
        final Entity two = ofEntity("test2");
        final Entity three = ofEntity("test3");
        final Entity four = ofEntity("test4");
        final Mono<Entity> apply = EntityNameValidator.apply(one, Flux.just(two, three, four));
        apply
                .map(entity -> entity.equals(one))
                .doOnSuccess(Assertions::assertTrue)
                .doOnError(Assertions::assertNotNull);
    }

    @Test
    void should_exception_entity_name_exist_in_collection(){
        final Entity one = ofEntity("test");
        final Entity two = ofEntity("test2");
        final Entity three = ofEntity("test3");
        final Entity four = ofEntity("test4");
        Mono<Entity> apply = EntityNameValidator.apply(three, Flux.just(one, two, three, four));
        apply
                .doOnSuccess(Assertions::assertNotNull)
                .doOnError(Assertions::assertNull);
    }

    private Entity ofEntity(String name) {
        return new Entity(UUID.randomUUID().toString(), name, true, List.of());
    }

}
