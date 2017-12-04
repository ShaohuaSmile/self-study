package shaohua.study.spring;

import org.springframework.stereotype.Component;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/14
 */
@Component
public class MessageDao {
    public String getHello(){
        return "Hello Spring...";
    }
}
