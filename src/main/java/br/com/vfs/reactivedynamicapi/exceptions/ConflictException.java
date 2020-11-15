package br.com.vfs.reactivedynamicapi.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}
