package br.com.vfs.reactivedynamicapi.web.entity.model;

import br.com.vfs.reactivedynamicapi.core.entity.model.CreateEntity;
import br.com.vfs.reactivedynamicapi.model.entity.Field;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateEntityRequest implements Serializable {

    private String name;
    private Collection<FieldRequest> fields;

    public CreateEntity toModel(){
        return new CreateEntity(name, toFields());
    }

    private Collection<Field> toFields() {
        return isNull(fields) ? List.of()
                : fields.stream().map(FieldRequest::toModel).collect(toList());
    }
}
