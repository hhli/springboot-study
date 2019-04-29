package com.hhli.springbootstduy.algothrims;

import java.util.Stack;

/**
 * @author 李辉辉
 * @date 2019/4/29 8:40
 * @description
 */
public class MinStack {
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int tmp = stack.peek();
            stack.push(x);
            if(tmp<x){
                stack.push(tmp);
            }else{
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
