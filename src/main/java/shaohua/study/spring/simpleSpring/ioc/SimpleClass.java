package shaohua.study.spring.simpleSpring.ioc;

import shaohua.study.spring.simpleSpring.ioc.annotation.Service;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 10:21
 */
@Service
public class SimpleClass {
    private String name;
    private int age;
    public void doing(){
        System.out.println("------simple doing----------");
        System.out.println("--name-"+name+"--age--"+age);
    }
}
