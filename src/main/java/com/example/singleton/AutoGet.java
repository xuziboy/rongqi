package com.example.singleton;

import java.lang.annotation.*;

/**
 * 自动注入注解
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoGet {
    /**
     * 该字段暂无特殊含义
     * @return
     */
    String value();
}
