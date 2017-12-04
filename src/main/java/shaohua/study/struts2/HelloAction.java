package shaohua.study.struts2;

import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/17 15:16
 */
public class HelloAction extends ActionSupport {
    public String say(){
        System.out.println("HelloAction================"+this.toString());
        Map<String,String> map = new HashMap<String,String>();
        map.put("hello","nimie");
        return "success";
    }
}
