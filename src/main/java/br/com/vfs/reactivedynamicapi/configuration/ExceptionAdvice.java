package br.com.vfs.reactivedynamicapi.configuration;

import br.com.vfs.reactivedynamicapi.exceptions.BaseException;
import br.com.vfs.reactivedynamicapi.exceptions.ConflictException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handle(final ConflictException exception){
        return ResponseEntity.status(CONFLICT).body("duplicate entity");
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(final BaseException exception){
        return ResponseEntity.status(BAD_REQUEST).body("default error 400");
    }
}
