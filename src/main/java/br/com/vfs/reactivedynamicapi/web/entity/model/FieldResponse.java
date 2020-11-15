package br.com.vfs.reactivedynamicapi.web.entity.model;

import br.com.vfs.reactivedynamicapi.model.entity.Field;
import br.com.vfs.reactivedynamicapi.model.entity.FieldType;
import lombok.Data;

import java.io.Serializable;
@Data
public class FieldResponse implements Serializable {

    private final String name;
    private final FieldType type;

    public FieldResponse(final Field field) {
        this.name = field.getName();
        this.type = field.getType();
    }
}
