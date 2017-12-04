package shaohua.study.collection;

import java.io.Serializable;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/9
 */
public interface MyMap<K,V> extends Serializable {
    interface MapNode<K,V> {
        K getKey();
        V getValue();
        void setValue(V v);
        MapNode<K,V> next();
    }
}
