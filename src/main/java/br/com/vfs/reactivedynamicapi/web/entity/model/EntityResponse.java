package br.com.vfs.reactivedynamicapi.web.entity.model;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityResponse implements Serializable {

    private String name;
    private boolean active;
    private Collection<FieldResponse> fields;

    public EntityResponse(final Entity entity) {
        this.name = entity.getName();
        this.active = entity.isActive();
        this.fields = entity.getFields().stream().map(FieldResponse::new).collect(toList());
    }
}
