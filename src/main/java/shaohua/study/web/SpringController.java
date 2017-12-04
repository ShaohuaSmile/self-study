package shaohua.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/10/30
 */
@Controller
@RequestMapping("/api")
public class SpringController {

    @RequestMapping("/getHello")
    @ResponseBody
    public String getHello(Person person){
        System.out.println("SpringController================"+this.toString());
        return "Hi " + person.getUserName() + ", Welcome !";
    }

    @RequestMapping("/getHelloPage")
    public String getHello(){
        return "Hello";
    }
}
