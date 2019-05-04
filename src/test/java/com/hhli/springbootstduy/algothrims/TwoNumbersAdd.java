package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/5/2 16:36
 * @description 两个链表相加
 */
public class TwoNumbersAdd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int temp = 0;
        int sum = 0;
        ListNode l3 = new ListNode(0);
        ListNode header = l3;
        while(l1!= null  || l2 != null){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            header.next = new ListNode( (sum+temp)%10);
            header = header.next;
            //进位
            temp = (sum + temp)/10;
            sum = 0;
        }
        if(temp>0){
            header.next = new ListNode(temp);
        }

        return  l3.next;
    }
}
