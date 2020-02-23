package com.hhli.springbootstduy.algothrims;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2020-02-13 15:58
 * @description 定制链表
 */
public class MySlefLinkedList {

    public static void main(String[] args) {
        int[] temp = new int[]{1, 5,2, 8};
        bubleSort(temp);
        System.out.println(Arrays.toString(temp));
    }


    public static void bubleSort(int[] tempArray){

        for (int i = 0; i < tempArray.length-1; i++) {
            for (int j = 0; j < tempArray.length - 1 - i; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }
    }

}




@Setter
@Getter
@ToString
class Node {


    private Integer data;

    private Node next;

    public Node(Integer data){
        this.data =data;
    }

    /**
     * 每个
     */

    public Node insert(Node head, Integer data){
        Node temp = new Node(data);
        if(Objects.isNull(head)){
            head = temp;
        }else if(Objects.nonNull(head.next)){
            Node tempHead = head;

            while(Objects.nonNull(tempHead.next)) {
                Node next = tempHead.next;
                if(data > tempHead.data){
                    temp.next = head;
                    head = temp;
                    break;
                }else if(data<next.data){
                    tempHead = tempHead.next;

                } else if(data == tempHead.data){
                    temp.next = tempHead.next;
                    head = temp;
                    break;

                } else if (data == next.data) {
                    head.next  = temp;
                    temp.next = next.next;
                    break;

                }else{
                    head.next = temp;
                    temp.next = tempHead.next;
                }
            }

        }else {
            if(head.data == data){
                head = temp;
            }else if(head.data> data){
                head.next = temp;
            }else{
                temp.next = head;
                head = temp;
            }
        }

        return  head;
    }

}

