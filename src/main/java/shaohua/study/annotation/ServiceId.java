package shaohua.study.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:指定Service唯一标识，用于辨别不同的Service
 *
 * @author Liush
 * @date 2018/05/15 15:00
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServiceId {
    String value() default "";
}
