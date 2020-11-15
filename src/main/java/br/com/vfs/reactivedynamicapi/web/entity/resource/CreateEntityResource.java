package br.com.vfs.reactivedynamicapi.web.entity.resource;

import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.core.entity.service.CreateEntityService;
import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.web.entity.model.CreateEntityRequest;
import br.com.vfs.reactivedynamicapi.web.entity.model.EntityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
class CreateEntityResource {

    private final CreateEntityService createEntityService;

    @PostMapping("/entities")
    @ResponseStatus(CREATED)
    public Mono<EntityResponse> create(@RequestBody final Mono<CreateEntityRequest> createEntityRequest){
        final Mono<CreateEntity> createEntity = createEntityRequest.map(CreateEntityRequest::toModel);
        final Mono<Entity> entity = createEntityService.apply(createEntity);
        return entity.map(EntityResponse::new);
    }

}
