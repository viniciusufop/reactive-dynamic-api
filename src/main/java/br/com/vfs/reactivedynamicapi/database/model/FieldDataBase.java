package br.com.vfs.reactivedynamicapi.database.model;

import br.com.vfs.reactivedynamicapi.model.entity.Field;
import br.com.vfs.reactivedynamicapi.model.entity.FieldType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FieldDataBase implements Serializable {

    private String name;
    private FieldType type;

    public FieldDataBase(final Field field) {
        this.name = field.getName();
        this.type = field.getType();
    }

    public Field toModel() {
        return new Field(name, type);
    }
}
