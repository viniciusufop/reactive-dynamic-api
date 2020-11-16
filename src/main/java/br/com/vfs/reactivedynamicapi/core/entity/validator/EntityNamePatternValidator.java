package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.exceptions.BaseException;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class EntityContainsFieldValidator implements CreateEntityValidator{
    @Override
    public Mono<Entity> apply(Mono<Entity> entityMono) {
        return entityMono
                .flatMap(this::validate);
    }

    private Mono<Entity> validate(final Entity entity) {
        if(entity.getFields().isEmpty()) return Mono.error(new BaseException());
        return Mono.just(entity);
    }
}
