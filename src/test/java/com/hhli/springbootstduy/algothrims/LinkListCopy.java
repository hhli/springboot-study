package com.hhli.springbootstduy.algothrims;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/5/4 15:49
 * @description 链表复制
 */
public class LinkListCopy {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Node newHead = new Node();

        Node newHeadTemp = newHead;
        Node headTemp = head;
        while(Objects.isNull(headTemp)){
            newHeadTemp.next = new Node(headTemp.val, null, null);
            newHeadTemp  = newHeadTemp.next;

            headTemp = headTemp.next;
        }



        return newHead.next;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
