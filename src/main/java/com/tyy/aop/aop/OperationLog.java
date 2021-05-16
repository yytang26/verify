package com.tyy.aop.aop;

import java.lang.annotation.*;

/**
 * @author:tyy
 * @date:2021/5/16
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

   String action() default "";

   String remark() default "";
}
