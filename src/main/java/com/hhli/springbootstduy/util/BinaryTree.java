package com.hhli.springbootstduy.util;


import java.util.ArrayList;
import java.util.List;

public class BinaryTree {


    public static void main(String[] args) {

    }


    /**
     *  判断树是否平衡，左右节点的高度差绝对值<=1
     * @param node 树跟节点
     * @return  true 平衡   false 不平衡
     */
    public static boolean isTreeBalance(DTreeNode node){
        boolean ret = true;
        if(node == null){
            return ret;
        }

        if(node.left == null && node.right == null){
            return  true;
        }else if(node.left != null && node.right == null){
            DTreeNode temp = node.left;
            if(temp.right != null || temp.left != null){
                return  false;
            }
        }else {
            DTreeNode temp = node.right;
            if(temp.right != null || temp.left != null){
                return  false;
            }
        }

        ret = isTreeBalance(node.left);
        if(ret && node.right != null){
            ret = isTreeBalance(node.right);
        }
        return  ret;
    }

    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String ans = s;
        String cycle = s + s;
        int g = gcd(n, b);

        for(int i=0; i<n; i+=g){
            String temp  = cycle.substring(i, i+n);
            for(int j=0; j<=9; j++){
                int th = a%2==0 ? 0:9;
                for(int k=0; k<=th;k++){
                    // System.out.println(temp);
                    char[] tempArray = temp.toCharArray();
                    for(int t=1; t<n; t+=2) tempArray[t] = (char)((tempArray[t] - '0' + a * j)%10 + '0');
                    for(int t=0; t<n; t+=2) tempArray[t] =  (char)((tempArray[t] - '0' + a * k)%10 + '0');

                    String c = new String(tempArray);
                    System.out.println(c);
                    ans = ans.compareTo(c)>0 ? c :ans;
                }
            }
        }

        return ans;
    }

    public int gcd(int x, int y){
        return y == 0 ?  x : gcd(y, x%y);
    }
}

/**
 * 树的节点定义
 */
class DTreeNode {
    /**
     * 节点值
     */
    int val;

    /**
     * 左节点
     */
    DTreeNode left;

    /**
     * 左节点
     */
    DTreeNode right;

    public DTreeNode(int val){
        this.val = val;
    }
}