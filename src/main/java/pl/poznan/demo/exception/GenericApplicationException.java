package pl.poznan.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericApplicationException extends RuntimeException {

    private final HttpStatus httpStatus;

    public GenericApplicationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
