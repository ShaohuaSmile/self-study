package shaohua.study.spring.simpleSpring.ioc.Reader;

import shaohua.study.spring.simpleSpring.ioc.annotation.Autowired;
import shaohua.study.spring.simpleSpring.ioc.annotation.Service;
import shaohua.study.spring.simpleSpring.ioc.beans.BeanDefinition;
import shaohua.study.spring.simpleSpring.ioc.beans.BeanReference;
import shaohua.study.spring.simpleSpring.ioc.beans.PropertyValue;
import shaohua.study.spring.simpleSpring.ioc.beans.PropertyValues;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 14:39
 */
public class AnnotationBeanDefinitionReader extends AbstractBeanDefinitionReader{
    @Override
    public void loadBeanDefinitions(String... packages) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        List<Class> classList = new ArrayList<Class>();
        for(String pkg:packages){
            String path = pkg.replace(".", "/");
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(path);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if("file".equals(url.getProtocol())){
                    path = url.getFile();
                    loadClass(path,pkg,classList);
                }else {
                    continue;
                }
            }
        }
        for(Class clazz:classList){
            Service service = (Service) clazz.getAnnotation(Service.class);
            String value = service.value();
            if("".equals(value)){
                String className = clazz.getSimpleName();
                value = className.substring(0,1).toLowerCase()+className.substring(1);
            }
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClassName(clazz.getName());
            //beanDefinition.setBeanClass(clazz);
            //beanDefinition.setBean(clazz.newInstance());
            PropertyValues pvs = new PropertyValues();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                Autowired autowired = field.getAnnotation(Autowired.class);
                if(autowired != null){
                    PropertyValue pv = new PropertyValue(field.getName(),new BeanReference(field.getName()));
                    pvs.addPropertyValue(pv);
                }
            }
            beanDefinition.setPropertyValues(pvs);
            getRegistry().put(value,beanDefinition);
        }
    }
    /**
     * 功能描述: 根据路径扫描类
     *
     * @param path 目录，不是文件    a/b/c/dddd
     * @author Liush
     * @date 2017/11/8
     */
    public List<Class> loadClass(String path,String javaPackage,final List<Class> clazzes) throws ClassNotFoundException {
        if(clazzes == null){
            new RuntimeException("clazzes 为空");
        }
        File file = new File(path);

        if(!file.exists() || !file.isDirectory()){
            return clazzes;
        }
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".class");
            }
        });
        for(File f:files){
            if(f.isFile()){
                //Class clazz = Class.forName(path.replace("/",".") + "." + f.getName());
                Class clazz = Thread.currentThread().getContextClassLoader().loadClass(javaPackage+"."+f.getName().substring(0,f.getName().length()-6));
                Annotation service = clazz.getAnnotation(Service.class);
                if(service != null){
                    clazzes.add(clazz);
                }
            }else{
                String subPath = path + "/" + f.getName();
                String subPackage = javaPackage + "." + f.getName();
                loadClass(subPath,subPackage,clazzes);
            }
        }
        return clazzes;
    }
}
