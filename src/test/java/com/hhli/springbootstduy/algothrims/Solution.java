package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/11 8:50
 * @description 链表反转
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        while (head != null){
            ListNode newHeadNext = newHead.next;
            ListNode headNext = head.next;
            newHead.next = head;
            newHead.next.next = newHeadNext;

            head = headNext;
        }

        return  newHead.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(1);
        ListNode head = h1;
        while (head !=null){
            System.out.println(head.val);
            head = head.next;
        }

        head = new Solution().reverseList(h1);
        while (head !=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString(){
        return String.valueOf(val);
    }

}
