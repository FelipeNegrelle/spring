package com.server.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private static final String hello = "Hello, %s!";

    private static AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello") @ResponseBody
    public Hello hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Hello(counter.incrementAndGet(), String.format(hello, name));
    }
}
