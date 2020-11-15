package br.com.vfs.reactivedynamicapi.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    public abstract HttpStatus getHttpStatus();
}
