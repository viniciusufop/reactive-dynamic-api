package br.com.vfs.reactivedynamicapi.database.model;

import br.com.vfs.reactivedynamicapi.model.entity.Entity;
import br.com.vfs.reactivedynamicapi.model.entity.Field;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Data
@Document
@NoArgsConstructor
public class EntityDataBase {
    @Id
    private String id;
    private String name;
    private boolean active;
    private Map<String, FieldDataBase> fields;

    public EntityDataBase(final Entity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.active = entity.isActive();
        this.fields = entity.getFields()
        .stream()
        .map(FieldDataBase::new)
        .collect(toMap(FieldDataBase::getName, field -> field));
    }

    public Entity toModel() {
        return new Entity(id, name, active, toFields());
    }

    private Collection<Field> toFields() {
        return isNull(fields) ? List.of()
                : fields.values().stream().map(FieldDataBase::toModel).collect(toList());
    }
}
