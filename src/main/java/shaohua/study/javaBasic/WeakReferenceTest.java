package shaohua.study.javaBasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 弱引用
 *
 * @author Liush
 * @date 2018/01/10 15:18
 */
public class WeakReferenceTest {
    public static List<WeakReference<Person>> list = new ArrayList<WeakReference<Person>>();
    public static void main(String[] args) {

        Integer i = null;//new Integer(9);
        System.out.println(i+"");

        System.exit(0);
        addPerson();
        Node node = new Node();
        bigObject(node);
        getPerson(list);
    }

    private static void bigObject(Node node) {
        int i = 0;
        while(i++ < 50){
            node.next = new Node();
            node.ary = null;
            node = node.next;
        }
    }

    private static void getPerson(List<WeakReference<Person>> list) {
        System.out.println(list.get(1).get().name);
    }

    private static void addPerson() {
        Person p = new Person();
        p.name = "ddddd";
        p.age = 20;
        WeakReference<Person> person = new WeakReference<Person>(p);
        list.add(person);
    }
}
class Person{
    String name;
    int age;
    public void finalize(){//执行这个方法即会回收改对象
        //System.out.println(this.name);
        WeakReferenceTest.list.set(0,new WeakReference<Person>(this));
        WeakReferenceTest.list.add(new WeakReference<Person>(this));
    }
}
class Node{
    String name;
    int[] ary = new int[1024*1024];
    Node next;
}
