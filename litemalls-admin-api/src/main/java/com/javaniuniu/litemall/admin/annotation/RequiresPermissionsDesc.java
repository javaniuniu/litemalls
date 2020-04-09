package com.javaniuniu.litemall.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求权限说明
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/4/9 4:49 PM
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermissionsDesc {
    String[] menu();

    String button();
}