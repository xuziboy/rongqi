package com.example.singleton.service;

import com.example.singleton.AutoSet;

@AutoSet(value = "TestSingleOne")
public class TestSingleOne {

    public TestSingleOne(){

    }

    public void test(){
        System.out.println("this is singleOne");
    }
}
