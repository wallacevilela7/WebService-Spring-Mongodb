package wvsdev.projetoapi.domain.resources.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wvsdev.projetoapi.domain.services.exception.ObjectNotFoundException;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        Long timestamp = Instant.now().toEpochMilli();
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(timestamp, status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}



