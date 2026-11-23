package io.github.parkwoong.example.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class CoreServerError extends RuntimeException {
    private final Map<String, Object> response;
}
