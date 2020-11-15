package br.com.vfs.reactivedynamicapi.core.entity.model;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.model.entity.Field;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Data
public class CreateEntity {

    private final String name;
    private final Collection<Field> fields;

    public CreateEntity(String name, Collection<Field> fields) {
        this.name = name;
        this.fields = isNull(fields) ? List.of() : fields;
    }

    public Entity entity(){
        return new Entity(UUID.randomUUID().toString(), name, true, fields);
    }
}
