package shaohua.study.spring.simpleSpring.ioc.Reader;

import java.io.IOException;

/**
 * 功能描述: bean配置信息读取
 *
 * @author Liush
 * @date 2017/11/08 14:24
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String... packages) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException;
}
