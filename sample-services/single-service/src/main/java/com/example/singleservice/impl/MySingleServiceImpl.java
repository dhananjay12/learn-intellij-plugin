package com.example.singleservice.impl;

import com.example.samplejar.MyInterface;

public class MySingleServiceImpl implements MyInterface {
    @Override
    public void test() {
        System.out.println("Single Service method");
    }
}
