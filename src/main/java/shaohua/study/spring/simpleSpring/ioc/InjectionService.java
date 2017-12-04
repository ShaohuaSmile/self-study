package shaohua.study.spring.simpleSpring.ioc;

import shaohua.study.spring.simpleSpring.ioc.annotation.Autowired;
import shaohua.study.spring.simpleSpring.ioc.annotation.Service;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/10 15:16
 */
@Service
public class InjectionService {
    @Autowired
    private SimpleClass simpleClass;
    public void hello(){
        simpleClass.doing();
    }
}
