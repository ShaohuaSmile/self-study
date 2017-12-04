package shaohua.study.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/15.
 */
public class HashMapStudy {
    public static void main(String... args){
        Map<String,String> map = new HashMap<String, String>();
        map.put("fdfd","fdfd");
        map.put("f444","fdfd");
        Set set = map.keySet();
        System.out.print("==============");
    }
}
