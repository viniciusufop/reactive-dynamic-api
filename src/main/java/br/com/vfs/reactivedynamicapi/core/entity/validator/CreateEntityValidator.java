package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;


public interface CreateEntityValidator extends Function<Mono<Entity>, Mono<Entity>> {

    default CreateEntityValidator compose(final CreateEntityValidator before) {
        Objects.requireNonNull(before);
        return (Mono<Entity> v) -> apply(before.apply(v));
    }
}
