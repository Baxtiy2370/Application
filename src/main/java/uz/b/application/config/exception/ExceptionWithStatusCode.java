package uz.b.application.config.exception;

import org.springframework.data.relational.core.sql.In;

public class ExceptionWithStatusCode extends Exception {

    private Integer httpStatusCode;
    private String errorMessageKey;

    public ExceptionWithStatusCode(Integer httpStatusCode, String errorMessageKey) {
        this.httpStatusCode = httpStatusCode;
        this.errorMessageKey = errorMessageKey;
    }

    public ExceptionWithStatusCode(Integer httpStatusCode, String errorMessageKey, Throwable cause) {
        super(cause);
        this.httpStatusCode = httpStatusCode;
        this.errorMessageKey = errorMessageKey;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }
    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }


    public ExceptionWithStatusCode setHttpStatusCode(Integer httpStatusCode){
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public ExceptionWithStatusCode setErrorMessageKey(String errorMessageKey){
        this.errorMessageKey = errorMessageKey;
        return this;
    }





}
