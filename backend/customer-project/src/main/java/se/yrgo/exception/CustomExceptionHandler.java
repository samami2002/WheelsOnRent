package se.yrgo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), errorMessage.getStatus(), request);
    }
}
