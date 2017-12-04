package shaohua.study.collection;/**
 * Created by Administrator on 2017/8/4.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/4
 */
public class Collections {
    public static void main(String... args){
        //System.out.println(args.length);
        String name="dfdf"+021020+"mkjlk"+args;
        List<SimpleObj> objs = new ArrayList<SimpleObj>();
        SimpleObj obj1=new Collections().new SimpleObj("zhangsan",21,1);
        SimpleObj obj2=new Collections().new SimpleObj("zha an",23,1);
        SimpleObj obj3=new Collections().new SimpleObj("zhangsan",21,2);
        SimpleObj obj4=new Collections().new SimpleObj("zhegsan",28,1);
        SimpleObj obj5=new Collections().new SimpleObj("z n",21,1);
        SimpleObj obj6=new Collections().new SimpleObj("z han san",23,2);
        objs.add(obj1);
        objs.add(obj2);
        objs.add(obj3);
        objs.add(obj4);
        objs.add(obj5);
        objs.add(obj6);
        java.util.Collections.sort(objs);
        for(SimpleObj obj:objs){
            System.out.println(obj.toString());
        }
    }
    public class SimpleObj implements Comparable<SimpleObj>{
        private String name;
        private int age;
        private int num;
        public SimpleObj(String name,int age, int num){
            this.num = num;
            this.age = age;
            this.name = name;
        }
        public int compareTo(SimpleObj o) {
            return this.age==o.age?(this.num-o.num):this.age-o.age;
        }
        public String toString(){
            return this.name+","+this.age+","+this.num;
        }
    }
}
