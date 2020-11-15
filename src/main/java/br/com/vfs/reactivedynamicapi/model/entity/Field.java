package br.com.vfs.reactivedynamicapi.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Field {
    private final String name;
    private final FieldType type;
}
