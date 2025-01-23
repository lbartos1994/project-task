package pl.poznan.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.poznan.demo.exception.GenericApplicationException;

import java.util.function.Function;

import static java.util.Objects.nonNull;

@Slf4j
public class BaseRestController {

    public <T, R> ResponseEntity<R> execute(final Function<T, R> method, T param) {
        try {
            return ResponseEntity.ok(method.apply(param));
        } catch (final GenericApplicationException e) {
            log.error("Ann error occurred", e);
            if (nonNull(e.getHttpStatus())) {
                return ResponseEntity.status(e.getHttpStatus()).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (final Exception e) {
            log.error("Ann error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
