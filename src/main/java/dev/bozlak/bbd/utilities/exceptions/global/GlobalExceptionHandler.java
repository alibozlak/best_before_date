package dev.bozlak.bbd.utilities.exceptions.global;

import dev.bozlak.core.responses.ResponseBodyWithMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBodyWithMessage> handleValidationExceptions(MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ResponseBodyWithMessage(false, errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBodyWithMessage> handleGeneralExceptions(Exception exception){
        return new ResponseEntity<>(
                new ResponseBodyWithMessage(false, exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
