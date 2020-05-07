package com.example.singleton.service;
import com.example.singleton.AutoGet;
import com.example.singleton.AutoSet;


@AutoSet(value = "TestSinglea")
public class AutoGetTest {

    @AutoGet(value = "1")
    private TestSingleOne testSingleOne;

    public void test(){
        testSingleOne.test();
    }


}
