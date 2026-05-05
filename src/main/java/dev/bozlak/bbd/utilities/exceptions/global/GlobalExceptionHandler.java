package dev.bozlak.bbd.utilities.exceptions.global;

import dev.bozlak.bbd.utilities.exceptions.user.UserNotFoundException;
import dev.bozlak.core.responses.ResponseBodyWithMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBodyWithMessage> handleValidationExceptions(MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        log.warn("Threw validation exception(s) : " + errorMessage);

        return new ResponseEntity<>(new ResponseBodyWithMessage(false, errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseBodyWithMessage> handleUserNotFoundException(UserNotFoundException e){

        log.warn("Threw UserNotFoundException : ", e.getMessage());

        return new ResponseEntity<>(
                new ResponseBodyWithMessage(false, e.getMessage()), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBodyWithMessage> handleGeneralExceptions(Exception exception){

        log.error("Unexpected system error : ", exception);

        return new ResponseEntity<>(
                new ResponseBodyWithMessage(false, exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
