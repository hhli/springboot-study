package com.hhli.springbootstduy.algothrims;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 12/4/22 4:39 PM
 * @description 全排列
 */
public class FullPermutation {
    private static  final String MAXTEMP = "122";

    public static void main(String[] args) {
        //List<List<Integer>> tempList = fullPermutation(new int[]{1, 2, 3, 4});
        List<List<Integer>> tempList = permute(new int[]{1, 2, 3, 4});
        System.out.println(tempList);
        System.out.println("===============");
        System.out.println(tempList.size());

        for(int i =0; true; i++){
            if(i==5){
                 break;
            }
        }
    }


    public static List<List<Integer>> fullPermutation(int[] nums){
        List<Choose> chooseList = new ArrayList<>();
        for(int i : nums){
            chooseList.add(new Choose(i));
        }

        List<List<Integer>> resultList = new ArrayList<>();
        supplementary(chooseList, resultList,  new ArrayList<>());

        return resultList;
    }

    public static void  supplementary(List<Choose> list, List<List<Integer>> resultList, List<Integer> result){
        if(result.size() == list.size()){
            resultList.add(new ArrayList<>(result));
            return;
        }

        for (Choose c : list) {
            if(c.isChoose()){
                continue;
            }

            c.setChoose(true);
            result.add(c.getNum());
            supplementary(list, resultList, result);
            result.remove(c.getNum());
            c.setChoose(false);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
            List<Integer> path, boolean[] used,
            List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}


@Data
class Choose {

    private Integer num;

    private boolean choose;

    public  Choose(int i){
        this.num = i;
    }
}