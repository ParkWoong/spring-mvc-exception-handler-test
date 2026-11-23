package io.github.parkwoong.example;

import io.github.parkwoong.example.exception.error.RequestError;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {
    @GetMapping("/sample/bad")
    public String bad() {
        throw new RequestError("Invalid sample");
    }

    @GetMapping("/sample/fail")
    public String fail() {
        throw new IllegalStateException("private detail");
    }
}
