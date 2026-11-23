package io.github.parkwoong.example.exception.error.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ErrorResponse {

    private String error;
    private String errorCode;
    private Object message;
}
