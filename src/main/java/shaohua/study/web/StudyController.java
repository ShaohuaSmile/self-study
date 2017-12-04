package shaohua.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/16 10:50
 */
@Controller
@RequestMapping("/study")
public class StudyController {

    @RequestMapping("/getHello")
    @ResponseBody
    public String getHello(String userName){
        return "Hi " + userName + ", Welcome !";
    }

    @RequestMapping("/getHelloPage")
    public String getHello(){
        return "Hello";
    }
}
