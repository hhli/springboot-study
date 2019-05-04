package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/5/4 12:44
 * @description 公共祖先
 */
public class CommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return  root;
        }else if(left != null){
            return  left;
        }else{
            return  right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
