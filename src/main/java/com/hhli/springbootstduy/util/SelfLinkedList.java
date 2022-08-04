package com.hhli.springbootstduy.util;

public  class SelfLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;

        Node n3 = new Node(3);
        n2.next = n3;

        Node n4 = new Node(4);
        n3.next = n4;

        Node n5 = new Node(5);
        n4.next = n5;

        testReserve(n1);

        n1 = reserve(n1);
        System.out.println("=========================");
        testReserve(n1);
    }

    /**
     * 链表反转
     * @param node 当前节点
     * @return 反转后的节点
     */
    public static Node reserve(Node node){
        Node head = new Node(0);

        while(node != null){
            Node nodeNext = node.next;

            Node headNext = head.next;
            head.next = node;
            node.next = headNext;

            node = nodeNext;
        }

        return head.next;
    }

    public static void testReserve(Node node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}


//链表节点
class Node {
    /**
     *  链表节点的值
     */
    int val;
    /**
     *  链表的后续节点
     */
    Node next;

    public  Node(int val){
        this.val = val;
    }


    public  Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

}