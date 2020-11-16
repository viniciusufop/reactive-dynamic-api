package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.exceptions.BaseException;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.model.entity.Field;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static java.util.Objects.isNull;

@Component
class EntityDuplicateFieldValidator implements CreateEntityValidator{
    @Override
    public Mono<Entity> apply(final Mono<Entity> entityMono) {
        return entityMono
                .filter(this::validate)
                .switchIfEmpty(Mono.error(new BaseException()));
    }

    private boolean validate(final Entity entity) {
        return entity.getFields()
                .stream()
                .filter(Objects::nonNull)
                .anyMatch(field -> isNotDuplicate(field, entity));
    }

    private boolean isNotDuplicate(final Field field, final Entity entity) {
        if(isNull(field.getName())) return true;
        return !entity.isDuplicateFieldName(field.getName());
    }
}
