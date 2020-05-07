package com.example.singleton;

import java.lang.annotation.*;

/**
 * 注入容器注解
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoSet {
    /**
     * 该字段暂无特殊含义
     * @return
     */
    String value();
}
