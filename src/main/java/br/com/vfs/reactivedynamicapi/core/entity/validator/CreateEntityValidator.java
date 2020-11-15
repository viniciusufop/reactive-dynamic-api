package br.com.vfs.reactivedynamicapi.core.entity.validator;

import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.model.errors.ValidatorFailure;
import reactor.core.publisher.Flux;

public interface CreateEntityValidator {

    Flux<ValidatorFailure> apply(final CreateEntity createEntity, final Flux<Entity> entities);

}
