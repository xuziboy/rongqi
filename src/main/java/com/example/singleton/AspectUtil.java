package com.example.singleton;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 面向切面类
 */
public class AspectUtil {

    /**
     * 将有@AutoSet注解的类放到容器中
     * @throws RuntimeException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static void setAll() throws RuntimeException, ClassNotFoundException, IllegalAccessException {
        Set set = ClassUtil.getClasses("com.example.singleton.service");
        for(Object url:set){
            String url1 = url.toString();
            String className = url1.substring(6);
            if(Class.forName(className).getAnnotation(AutoSet.class)!=null){
                SingleTonRegistry.addSingle(className);
            }
        }
    }

    /**
     * 将有@AutoGet注解的字段进行自动注入
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static void setFieldAll() throws ClassNotFoundException, IllegalAccessException {
        Map map = SingleTonRegistry.getAllSingle();
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            Field[] fields = Class.forName(entry.getKey().toString()).getDeclaredFields();
            for(Field field:fields){
                if(field.getAnnotation(AutoGet.class)!=null){
                    String s = field.getType().toString().substring(6);
                    field.setAccessible(true);
                    field.set(SingleTonRegistry.getSingletonObject(entry.getKey().toString()),
                            SingleTonRegistry.getSingletonObject(s));
                }
            }
        }

    }

}
