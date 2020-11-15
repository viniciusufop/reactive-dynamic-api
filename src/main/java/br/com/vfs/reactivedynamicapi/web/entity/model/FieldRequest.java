package br.com.vfs.reactivedynamicapi.web.entity.model;

import br.com.vfs.reactivedynamicapi.model.entity.Field;
import br.com.vfs.reactivedynamicapi.model.entity.FieldType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FieldRequest implements Serializable {

    private String name;
    private FieldType type;

    Field toModel(){
        return new Field(name, type);
    }
}
