package shaohua.study.spring.simpleSpring.ioc.Reader;


import shaohua.study.spring.simpleSpring.ioc.annotation.Service;
import shaohua.study.spring.simpleSpring.ioc.beans.BeanDefinition;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 14:26
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private Map<String, BeanDefinition> registry;

    public AbstractBeanDefinitionReader(){
        this.registry = new HashMap<String, BeanDefinition>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

}
