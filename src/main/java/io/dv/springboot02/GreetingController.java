package io.dv.springboot02;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController {
    
    private static final String _TMP = "Hello,%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        log.info("<=========provide greeting RESTfull api");
        return Greeting.builder()
        .id(counter.incrementAndGet())
        .content(String.format(_TMP, name))
        .build();
    }
}