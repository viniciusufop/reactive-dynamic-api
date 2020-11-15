package br.com.vfs.reactivedynamicapi.web.entity.model;

import br.com.vfs.reactivedynamicapi.model.entity.Field;
import br.com.vfs.reactivedynamicapi.model.entity.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FieldResponse implements Serializable {

    private String name;
    private FieldType type;

    public FieldResponse(final Field field) {
        this.name = field.getName();
        this.type = field.getType();
    }
}
