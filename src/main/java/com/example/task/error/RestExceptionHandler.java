package com.example.task.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest request) {
        ApiErrorReponse apiErrorResponse = new ApiErrorReponse();


        apiErrorResponse.setError_remark(ex.getMessage());
        apiErrorResponse.setError_message("bb");
        apiErrorResponse.setError_code("aa");
        apiErrorResponse.setResult(0);
        apiErrorResponse.setTimestamp(new Date());
        return buildResponseEntity(apiErrorResponse);

    }
    @ExceptionHandler(DateTimeFormatErrorException.class)
    public final ResponseEntity<Object> DatetimeErrorMethod(DateTimeFormatErrorException ex){

        ApiErrorReponse apiErrorResponse = new ApiErrorReponse();

        apiErrorResponse.setError_remark(ex.getMessage());
        apiErrorResponse.setError_message("Please Please !。");
        apiErrorResponse.setError_code("DateTimeFormatError");
        apiErrorResponse.setResult(0);
        apiErrorResponse.setTimestamp(new Date());
        return buildResponseEntity(apiErrorResponse);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public final ResponseEntity<Object> EmailErrorMethod(AlreadyExistException ex){

        ApiErrorReponse apiErrorResponse = new ApiErrorReponse();

        apiErrorResponse.setError_remark(ex.getMessage());
        apiErrorResponse.setError_message("Email Already Exsit!。");
        apiErrorResponse.setError_code("EmailError");
        apiErrorResponse.setResult(0);
        apiErrorResponse.setTimestamp(new Date());
        return buildResponseEntity(apiErrorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiErrorReponse apiError) {
        return new ResponseEntity<>(apiError, HttpStatus.OK);
    }
}
