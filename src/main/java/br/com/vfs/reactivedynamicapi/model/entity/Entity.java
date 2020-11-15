package br.com.vfs.reactivedynamicapi.model.entity;

import lombok.Data;

import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;

@Data
public class Entity {
    private final String id;
    private final String name;
    private final boolean active;
    private final Collection<Field> fields;

    public Entity(final String id, final String name, final boolean active, final Collection<Field> fields) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.fields = isNull(fields) ? List.of() : fields;
    }
}
