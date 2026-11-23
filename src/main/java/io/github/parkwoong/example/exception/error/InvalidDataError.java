package io.github.parkwoong.example.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.validation.BindingResult;

@Getter
@Setter
@RequiredArgsConstructor
public class InvalidDataError extends RuntimeException {
    private final BindingResult result;
}
