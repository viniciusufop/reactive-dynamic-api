package br.com.vfs.reactivedynamicapi.model.errors;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ValidatorFailure {

    private final String error;

}
