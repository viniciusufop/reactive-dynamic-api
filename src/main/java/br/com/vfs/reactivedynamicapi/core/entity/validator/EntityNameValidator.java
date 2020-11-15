package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.exceptions.ConflictException;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.Objects.isNull;

@UtilityClass
public class EntityNameValidator {

    public static Mono<Entity> apply(final Entity newEntity, Flux<Entity> entityFlux){
        return entityFlux
                .any(entity -> isEqualName(newEntity, entity))
                .flatMap(exist -> isExistName(exist, newEntity));
    }

    private static Mono<Entity> isExistName(final Boolean exist, final Entity newEntity) {
        if (exist) return Mono.error(new ConflictException());
        return Mono.just(newEntity);

    }

    private static boolean isEqualName(final Entity newEntity, final Entity entity) {
        final String newName = processName(newEntity.getName());
        final String name = processName(entity.getName());
        return newName.equalsIgnoreCase(name);
    }

    private static String processName(final String name) {
        if(isNull(name)) return "";
        return name;
    }
}
