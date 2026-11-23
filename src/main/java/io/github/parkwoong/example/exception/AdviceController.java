package io.github.parkwoong.example.exception;

import io.github.parkwoong.example.exception.error.CoreServerError;
import io.github.parkwoong.example.exception.error.InvalidDataError;
import io.github.parkwoong.example.exception.error.RequestError;
import io.github.parkwoong.example.exception.error.common.ErrorCode;
import io.github.parkwoong.example.exception.error.common.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class AdviceController {

    private static final String ERROR_KEY = "errorMessage";

    @ExceptionHandler(RequestError.class)
    public ResponseEntity<ErrorResponse> returnException(RequestError e) {

        final Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put(ERROR_KEY, e.getErrorMessage());

        final ErrorResponse error =
                ErrorResponse.builder()
                        .error("Request Error")
                        .errorCode(ErrorCode.INVALID_REQUEST_ERROR.getCode())
                        .message(errorMessage)
                        .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InvalidDataError.class)
    public ResponseEntity<ErrorResponse> returnException(InvalidDataError e) {

        final Object errors =
                e.getResult() == null
                        ? null
                        : e.getResult().getFieldErrors().stream()
                                .collect(
                                        Collectors.toMap(
                                                FieldError::getField,
                                                FieldError::getDefaultMessage,
                                                (a, b) -> a));

        final ErrorResponse error =
                ErrorResponse.builder()
                        .error("Invalid Data Request Error")
                        .errorCode(ErrorCode.INVALID_REQUEST_ERROR.getCode())
                        .message(errors)
                        .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(CoreServerError.class)
    public ResponseEntity<ErrorResponse> returnException(CoreServerError e) {

        final ErrorResponse error =
                ErrorResponse.builder()
                        .error("Internal Server Error")
                        .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                        .message(e.getResponse())
                        .build();

        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> returnException(Exception e) {

        final Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put(ERROR_KEY, "Unexpected error");

        final ErrorResponse error =
                ErrorResponse.builder()
                        .error("Internal Server Error")
                        .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                        .message(errorMessage)
                        .build();

        return ResponseEntity.internalServerError().body(error);
    }
}
