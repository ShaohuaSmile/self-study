//package shaohua.study.algorithms;
//
///**
// * 功能描述:
// *
// * @author Liush
// * @date 2018/12/25 10:25
// */
//public class MergeLinkedList {
//    public static void main(String... args){
//        Node<Integer> listOne = new Node<>(1);
//        listOne.append(2).append(3).append(4).append(4).append(4).append(5).append(5).append(8).append(9).append(9);
//
//        Node<Integer> listTwo = new Node<>(4);
//        listTwo.append(5).append(6).append(6).append(7).append(7).append(7).append(8).append(8).append(9).append(9);
//
//        //print(merge(listOne,listTwo));
//        print(whileMerge(listOne,listTwo));
//    }
//    public static Node<Integer> merge(Node<Integer> one, Node<Integer> two){
//        if(one == null) return two;
//
//        if(two == null) return one;
//
//        if(one.value < two.value){
//            one.next = merge(one.next, two);
//            return one;
//        }else {
//            two.next = merge(two.next, one);
//            return two;
//        }
//    }
//    public static Node<Integer> whileMerge(Node<Integer> one, Node<Integer> two){
//        Node head = new Node(-1);
//        Node curTail = head;
//        while (one != null && two != null){
//            while(one != null && one.value < two.value){
//                curTail.next = one;
//                curTail = curTail.next;
//                one = one.next;
//            }
//            while(two != null && one.value >= two.value){
//                curTail.next = two;
//                curTail = curTail.next;
//                two = two.next;
//            }
//        }
//        if(one == null) curTail.next = two;
//
//        if(two == null) curTail.next = one;
//
//        return head.next;
//    }
//    public static void print(Node node){
//        if(node == null)
//            return;
//        System.out.print(node.value);
//        print(node.next);
//    }
//}
//class Node<T>{
//    T value;
//    Node<T> next;
//    Node<T> append(T value){
//        next = new Node<>(value);
//        return next;
//    }
//    Node(T i){
//        this.value = i;
//    }
//}
