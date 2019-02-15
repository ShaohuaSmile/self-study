package shaohua.study.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/08/07 16:55
 */
public class JDK8HashMapTreeNodeTest {
    public static void main(String... args) throws Exception {
        Map<MyInt,String> map = new HashMap<>();
        for(int i=0; i<10; i++){
            map.put(new MyInt(i),"");
        }
        Field tableField= map.getClass().getDeclaredField("table");
        tableField.setAccessible(true);
        HashMap.Entry<MyInt,String>[] o = (Map.Entry<MyInt, String>[]) tableField.get(map);
        map.get(new MyInt(3));

        System.out.println();
    }
    static class MyInt{
        int value;
        MyInt(int v){
            this.value = v;
        }

        public int hashCode(){
            return 1;
        }
        public boolean equals(Object obj){
            if(obj == null)
                return false;
            if(this == obj)
                return true;
            if(obj instanceof MyInt){
                return ((MyInt) obj).value == this.value;
            }
            return false;
        }
    }
}
