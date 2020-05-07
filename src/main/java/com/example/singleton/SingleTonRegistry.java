package com.example.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册容器和获取的处理类
 */
public class SingleTonRegistry {

    /**
     * 单例对象缓存容器
     */
    private static Map<String,Object> singletonObject = new ConcurrentHashMap<>();


    public static void addSingle(String name){
        try{
            singletonObject.put(name,Class.forName(name).newInstance());
        }catch (ClassNotFoundException e){
            throw new RuntimeException("注册实例错误"+e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static <T>T getSingletonObject(String name){
        Object bean =  singletonObject.get(name);
        if(bean == null){
            throw new RuntimeException("没有找到实例");
        }
        return (T)bean;
    }

    public static Map getAllSingle(){
        return singletonObject;
    }
}
