package io.github.parkwoong.example.exception.error.common;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_REQUEST_ERROR("API400", null),
    INTERNAL_SERVER_ERROR("API500", null);

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
