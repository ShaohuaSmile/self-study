package shaohua.study.spring.simpleSpring.ioc.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:自动装配注解
 *
 * @author Liush
 * @date 2017/11/08 15:09
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
}
