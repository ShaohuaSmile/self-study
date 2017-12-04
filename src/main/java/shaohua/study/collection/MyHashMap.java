package shaohua.study.collection;
import java.util.Iterator;
/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/8
 */
public class MyHashMap<K,V> implements MyMap<K,V>{
    /**
     * 长度
     */
     private int size;
    /**
     * 加载因子 扩容使用
     */
     private float expandPer = 0.75f;

    /**
     * 需要自己实现writeObject、readObject方法
     */
    transient final Entry<K,V>[] table = new Entry[16];

    transient MySet<MyMap.MapNode<K,V>> set;

    public void put(K key, V value){
        Entry<K,V> newNode = new Entry<K, V>(hash(key),key,value);
        //hash算法
        //int index = hash(key) % table.length;
        int tableIndex = tableIndex(key);
        if(table[tableIndex] == null){
            table[tableIndex] = newNode;
            size++;
            return;
        }
        Entry<K,V> head = table[tableIndex];
        for(;;){
            if(head.key == key || head.key.equals(key)){
                //exist key
                return;
            }
            head = head.next;
            if(head == null){
                break;
            }
        }
        newNode.next = table[tableIndex];
        table[tableIndex] = newNode;
        size++;

    }
    public V get(K key){
        int tableIndex = tableIndex(key);
        Entry<K,V> resEntry = table[tableIndex];
        while(resEntry != null){
            if(resEntry.key == key || resEntry.key.equals(key)){
                return resEntry.value;
            }
            resEntry = resEntry.next;
        }
        return null;
    }
    public MySet<MyMap.MapNode<K,V>> entrySet(){
        if(set == null){
            set = new ShaoHuaSet();
        }
        return set;
    }
    private int hash(K key){
        return key==null?0:key.hashCode();
    }
    private int tableIndex(K key){
        return hash(key) & (table.length-1);
    }
    static class Entry<K,V> implements MyMap.MapNode<K,V>{
         int hash;
         K key;
         V value;
         Entry<K,V> next;

        public Entry(int hash,K key, V value){
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return "[key:"+key+",value:"+value+"]";
        }
        public MapNode<K,V> next(){
            return next;
        }

         public K getKey() {
             return key;
         }

         public V getValue() {
             return value;
         }

         public void setValue(V v) {
            this.value = v;
         }

     }
    final class ShaoHuaSet extends MySet<MyMap.MapNode<K,V>> implements Iterable<MyMap.MapNode<K,V>>{
        public final int size()                 { return size; }
        /**
         * Returns an iterator over elements of type {@code T}.
         *
         * @return an Iterator.
         */
        public Iterator<MyMap.MapNode<K,V>> iterator() {
            return new Iterator() {
                private int currentTable = 0;
                private int currentIndex = 0;
                private Entry<K,V> current = table[currentTable];
                public boolean hasNext() {
                    return currentIndex < size-1;
                }
                public Entry<K,V> next() {
                    currentIndex++;
                    while(current == null){
                        current = table[++currentTable];
                    }
                    Entry<K,V> resNode = current;
                    if(current.next != null){
                        current = current.next;
                        return resNode;
                    }
                    current = table[++currentTable];
                    return resNode;
                }
                public void remove() {
                    throw new RuntimeException("不允许更改");
                }
            };
        }
    }
    public int size(){
        return size;
    }
}
