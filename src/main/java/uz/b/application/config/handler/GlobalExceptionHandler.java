package uz.b.application.config.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.b.application.config.core.GenericResponse;
import uz.b.application.config.exception.BadRequestException;
import uz.b.application.config.exception.EntityNotFoundException;
import uz.b.application.config.exception.EnumValidationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        FieldError fieldError = ex.getFieldErrors().get(0);
        String field = fieldError.getField();

        errors.put("data", null);
        errors.put("errorMessage", field.concat("").concat(Objects.requireNonNull(fieldError.getDefaultMessage())));
        errors.put("timestamp", String.valueOf(System.currentTimeMillis()));


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> runtimeException(RuntimeException e) {
        return GenericResponse.error500(e.getMessage());
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound(EntityNotFoundException e) {
        return GenericResponse.badRequest400(e.getMessage());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e) {
        return GenericResponse.badRequest400(e.getMessage());
    }

    @ExceptionHandler(value = EnumValidationException.class)
    public ResponseEntity<?> enumValidateException(EnumValidationException e) {
        return GenericResponse.badRequest400(e.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<?> nullPointerException(NullPointerException e) {
        return GenericResponse.error500(e.getMessage());
    }


}
