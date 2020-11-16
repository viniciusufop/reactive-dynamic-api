package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.exceptions.BaseException;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

@Component
class EntityNamePatternValidator implements CreateEntityValidator{
    @Override
    public Mono<Entity> apply(Mono<Entity> entityMono) {
        return entityMono
                .flatMap(this::validate);
    }

    private Mono<Entity> validate(final Entity entity) {
        if(isValidPattern(entity.getName())) return Mono.error(new BaseException());
        return Mono.just(entity);
    }

    private boolean isValidPattern(final String name) {
        return nonNull(name) && name.matches("[a-zA-Z0-9]+");
    }
}
