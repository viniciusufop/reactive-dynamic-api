package br.com.vfs.reactivedynamicapi.web.entity.model;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Data
public class EntityResponse implements Serializable {

    private final String name;
    private final boolean active;
    private final Collection<FieldResponse> fields;

    public EntityResponse(final Entity entity) {
        this.name = entity.getName();
        this.active = entity.isActive();
        this.fields = entity.getFields().stream().map(FieldResponse::new).collect(toList());
    }
}
