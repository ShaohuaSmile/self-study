package shaohua.study.collection;
import shaohua.study.collection.MyHashMap.ShaoHuaSet;
import shaohua.study.collection.MyHashMap.Entry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/8
 */
public class Test {
    public static void main(String... args){
        MyHashMap<String,String> map = new MyHashMap<String,String>();
        map.put("lili","A");
        map.put("lili","A");
        map.put("Shaohua","c");
        map.put("zhongzhuang","b");
        for(int i=0;i<1000;i++){
            map.put("key"+i,"value"+i);
        }
        System.out.println(map.get("lili"));
        System.out.println("=============");
        MySet<MyMap.MapNode<String,String>> set = map.entrySet();
        for(MyMap.MapNode<String,String> entry : set){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("======fffffffffffffffffffffff=======");
        Iterator iterator =  map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println(map.size());
    }
    private static void map(){
        Map<String,String> map = new HashMap<String,String>();
        Set<Map.Entry<String,String>> set = map.entrySet();
    }
}
