package com.example.singleton;
import com.example.singleton.service.AutoGetTest;

public class TestUtil {

    public static void main(String[] args) {

        try{
            AspectUtil.setAll();
            AspectUtil.setFieldAll();
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        AutoGetTest test = SingleTonRegistry.getSingletonObject("com.example.singleton.service.AutoGetTest");
        test.test();
    }



}
