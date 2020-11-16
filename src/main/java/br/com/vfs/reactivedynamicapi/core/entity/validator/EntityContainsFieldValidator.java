package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.exceptions.BaseException;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class EntityContainsFieldValidator implements CreateEntityValidator{
    @Override
    public Mono<Entity> apply(final Mono<Entity> entityMono) {
        return entityMono
                .filter(this::validate)
                .switchIfEmpty(Mono.error(new BaseException()));
    }

    private boolean validate(final Entity entity) {
        return !entity.getFields().isEmpty();
    }
}
