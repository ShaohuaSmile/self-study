package shaohua.study.spring.simpleSpring.ioc.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 14:59
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";
}
