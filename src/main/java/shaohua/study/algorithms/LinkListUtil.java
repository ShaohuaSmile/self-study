package shaohua.study.algorithms;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2019/01/06 16:43
 */
public class LinkListUtil {

    public static void main(String... args){
        //初始化一个list
        Node<Integer> head = new Node<>();
        head.setValue(0);
        Node temp = head;
        for(int i=1; i<10; i++){
            Node<Integer> node = new Node<>();
            node.setValue(i);
            temp.setNext(node);
            node.setPrev(temp);
            temp = node;
        }
        //可视化输出
        Node t = printNext(head);
        Node h = printPrev(t);
        System.out.println("反转后：");
        reverse(head);
        Node hr = printPrev(head);
        Node tr = printNext(hr);
        /*
          正向：0->1->2->3->4->5->6->7->8->9->
          反向：9->8->7->6->5->4->3->2->1->0->
          反转后：
          反向：0->1->2->3->4->5->6->7->8->9->
          正向：9->8->7->6->5->4->3->2->1->0->
          */
    }

    /**
     * 功能描述: 验证方法 不全
     *
     * @author Liush
     * @date 2019/1/6
     */
    public static boolean validateReverse(Node head){
        Node cloned = clone(head);
        Node tail = reverse(head);
        while (cloned != null){
            if(tail == null){
                return false;
            }
            if(cloned.getValue() != tail.getValue()){
                return false;
            }
            cloned = cloned.getNext();
            tail = tail.getPrev();
        }
        return true;
    }

    /**
     * 功能描述: 复制一个list  浅度复制到Node级别
     *
     * @author Liush
     * @date 2019/1/6
     */
    public static Node clone(Node node){
        if(node == null){
            return node;
        }
        Node cloned = new Node();
        cloned.setValue(node.getValue());
        Node temp = cloned;
        while ((node = node.getNext()) != null){
            Node newNode = new Node();
            newNode.setValue(node.getValue());
            temp.setNext(newNode);
            newNode.setPrev(temp);
            temp = newNode;
        }
        return cloned;
    }

    /**
     * 功能描述: 正向输出
     *
     * @author Liush
     * @date 2019/1/6
     */
    public static Node printNext(Node head){
        System.out.print("正向：");
        if(head == null){
            System.out.print("null");
            return head;
        }
        Node tail;
        do{
            System.out.print(head.getValue() + "->");
            tail = head;
        }while ((head = head.getNext()) !=null);
        System.out.println();
        return tail;
    }

    /**
     * 功能描述: 反向输出
     *
     * @author Liush
     * @date 2019/1/6
     */
    public static Node printPrev(Node tail){
        System.out.print("反向：");
        if(tail == null){
            System.out.print("null");
            return tail;
        }
        Node head;
        do{
            System.out.print(tail.getValue() + "->");
            head = tail;
        }while ((tail = head.getPrev()) !=null);
        System.out.println();
        return head;
    }

    /**
     * 功能描述: 将双向链表反转
     * @return 反转后的尾
     * @author Liush
     * @date 2019/1/6
     */
    public static Node reverse(Node head){
        if(head == null){
            return head;
        }
        Node next = head.getNext();
        head.setNext(head.getPrev());
        head.setPrev(reverse(next));
        return head;
    }
}
class Node<T> {
    private T value;
    private Node prev;
    private Node next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
