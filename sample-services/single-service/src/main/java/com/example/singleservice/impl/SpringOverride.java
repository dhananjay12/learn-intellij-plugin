package com.example.singleservice.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;

public class SpringOverride extends SpringApplicationEvent {
    public SpringOverride(SpringApplication application, String[] args) {
        super(application, args);
    }
}
