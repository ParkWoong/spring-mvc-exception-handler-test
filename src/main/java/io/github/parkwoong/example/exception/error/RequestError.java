package io.github.parkwoong.example.exception.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestError extends RuntimeException {

    private String errorMessage = "BadRequestError";

    public RequestError() {}
    ;

    public RequestError(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
    ;
}
