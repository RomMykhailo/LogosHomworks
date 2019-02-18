package com.example.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class TestComponent {
    @PostConstruct
    public void init(){
        log.info("Hello");
    }
}
