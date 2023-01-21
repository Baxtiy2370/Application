package uz.b.application.config.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class GenericResponse<T> {
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("data")
    private T data;

    public GenericResponse(T data) {
        this.timestamp = System.currentTimeMillis();
        this.errorMessage = "";
        this.data = data;
    }

    public GenericResponse(String errorMessage) {
        this.timestamp = System.currentTimeMillis();
        this.errorMessage = errorMessage;
        this.data = null;
    }


    public static <T> ResponseEntity<GenericResponse<T>> success200(T data) {
        return ResponseEntity.ok(
                new GenericResponse<>(data)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success201(T data){
        return new ResponseEntity<>(
                new GenericResponse<>(data), HttpStatus.CREATED
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error500(String errorMessage){
        return new ResponseEntity<>(
                new GenericResponse<>(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    public static <T> ResponseEntity<GenericResponse<T>> errorStatus(String errorMessage, HttpStatus status){
        return new ResponseEntity<>(
                new GenericResponse<>(errorMessage),status
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> notAuth(String errorMessage){
        return new ResponseEntity<>(
                new GenericResponse<>(errorMessage), HttpStatus.UNAUTHORIZED
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> notAccess(String errorMessage){
        return new ResponseEntity<>(
                new GenericResponse<>(errorMessage), HttpStatus.FORBIDDEN
        );
    }


    public static <T> ResponseEntity<GenericResponse<T>> badRequest400(String errorMessage){
        return new ResponseEntity<>(
                new GenericResponse<>(errorMessage), HttpStatus.BAD_REQUEST
        );
    }


    public static <T> ResponseEntity<GenericResponse<T>> notFound(String errorMessage){
        return new ResponseEntity<>(
                new GenericResponse<>(errorMessage), HttpStatus.NOT_FOUND
        );
    }

}
