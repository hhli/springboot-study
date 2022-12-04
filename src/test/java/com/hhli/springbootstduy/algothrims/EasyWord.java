package com.hhli.springbootstduy.algothrims;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李辉辉
 * @date 4/17/22 4:50 PM
 * @description
 */
public class EasyWord {

    public static void main(String[] args) {
        //System.out.println(longestWord(new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"}));
        //
        //Lock lock = new ReentrantLock();
        //lock.newCondition();

        //ListNode n1 = new ListNode(1);
        //ListNode n2 = new ListNode(2);
        //n1.next = n2;
        //ListNode n3 = new ListNode(3);
        //n2.next = n3;
        //ListNode n4 = new ListNode(4);
        //n3.next = n4;
        //ListNode n5 = new ListNode(5);
        //n4.next = n5;

        //reverseKGroup(n1, 2);

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n3.left = n4;
        n3.right = n5;

        System.out.println(averageHeight(n1));
        System.out.println(averageHeight2(n1));
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }

        ListNode newH = new ListNode(0);
        ListNode tempNewH = newH;
        ListNode tempH = head;
        while(tempH != null){
            ListNode begin = tempH;
            ListNode end = tempH;
            int i = 0;
            for(; i<k; i++){
                end = end.next;
                if(end == null){
                    break;
                }
            }

            if(i < k){
                tempNewH.next =  begin;
                break;
            }else {
                tempH = end;
                tempNewH = reserve(tempNewH, begin, end);
            }
        }

        return newH.next;
    }

    private static ListNode reserve(ListNode newH, ListNode begin, ListNode end){
        ListNode b = begin;
        while(b != end){
            ListNode temp = newH.next;
            ListNode next = b.next;
            newH.next = b;
            b.next = temp;
            b = next;
        }

        return begin;
    }

    public static  String mostCommonWord(String paragraph, String[] banned) {
        int begin = 0;
        paragraph = paragraph.toLowerCase();
        Map<String, Integer> word2Count = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if(c>='a' && c<='z'){
                continue;
            }

            String  s = paragraph.substring(begin, i);
            begin = i+1;
            if("".equals(s)){
                continue;
            }

            if(word2Count.containsKey(s)){
                word2Count.put(s, word2Count.get(s) + 1);
            }else{
                word2Count.put(s, 1);
            }
        }

        if(begin<paragraph.length()){
            String  s = paragraph.substring(begin);
            if(word2Count.containsKey(s)){
                word2Count.put(s, word2Count.get(s) + 1);
            }else{
                word2Count.put(s, 1);
            }
        }

        for (String s : banned) {
         word2Count.remove(s);
        }

        int i = 0;
        String s = "";
        for (Map.Entry<String, Integer> entry : word2Count.entrySet()) {
            if(i < entry.getValue()){
                i = entry.getValue();
                s = entry.getKey();
            }
        }

        return s;
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        for (int i = 0; i < s.toCharArray().length; i++) {
        }
        return 0;
    }

    private static int calc(String s) {
        String[] strArray = s.split("[+|\\-|*|/]");
        int s1 = Integer.parseInt(strArray[0]);
        char op  = strArray[1].charAt(0);
        int s2 = Integer.parseInt(strArray[2]);

        switch(op) {
            case '+':
                return s1 + s2;
            case '-':
                return s1 - s2;
            case '*':
                return s1 *s2;
            case '/':
                return s1/s2;
        }
        return 0;
    }

    public static int numPrimeArrangements(int n) {
        int primes = 0;
        for (int i = 1; i <= n; i++) {
            if(isPrime(i)){
                primes++;
            }
        }

        BigDecimal result= new BigDecimal(1);
        for(int i=2; i<=primes;i++){
            BigDecimal tempValue = new BigDecimal(i);
            result = result.multiply(tempValue);
        }

        for(int i=2; i<=n-primes;i++){
            BigDecimal tempValue = new BigDecimal(i);
            result = result.multiply(tempValue);
        }

        return result.remainder(new BigDecimal(Math.pow(10, 9)+7)).intValue();
    }

    private static boolean isPrime(int x){
        if(x == 1) {
            return false;
        }

        if(x == 2) {
            return true;
        }

        int sq = (int)Math.sqrt(x);
        for (int i = 2; i <= sq; i++) {
            if(x%i == 0){
                return false;
            }
        }

        return  true;
    }


    private Map<Character,List<String>> CharacterMap = new HashMap<Character,List<String>>(){{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "0"));
        put('7', Arrays.asList("p","q", "r", "s"));
        put('8', Arrays.asList("t","u", "v"));
        put('9', Arrays.asList("w","x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }

        if(digits.length()==1){
            return CharacterMap.get(digits.charAt(0));
        }

        List<String> resultList = letterCombinations(digits.substring(1));
        List<String> prefixList = CharacterMap.get(digits.charAt(0));


        List<String> finalResultList = new ArrayList<>();
        for (String s : prefixList) {
            for (String s1 : resultList) {
                finalResultList.add(s + s1);
            }
        }

        return finalResultList;
    }

    public static  boolean canJump(int[] nums) {
        return jump(nums, 0, nums.length-1);
    }

    public static boolean jump(int[] nums, int start, int end){
        if(nums[start] >= (end - start)){
            return true;
        }

        boolean ret = false;
        for(int i=1; i<=nums[start]; i++){
            if(ret = jump(nums, start+i, end)){
                break;
            }
        }

        return ret;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        Set<String> strSet = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int x =  j+1;
                int y = n-1;
                long temp = (long)target - nums[i] - nums[j];
                while(x < y){
                    if(nums[x] + nums[y] == temp){
                        StringBuilder tempBuilder = new StringBuilder();
                        tempBuilder.append(nums[i]);
                        tempBuilder.append(",").append(nums[j]);
                        tempBuilder.append(",").append(nums[x]);
                        tempBuilder.append(",").append(nums[y]);
                        strSet.add(tempBuilder.toString());
                        y--;
                    }else if(nums[x] + nums[y] > temp){
                        y--;
                    }else {
                        x++;
                    }
                }
            }
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for(String str : strSet){
            String[] tempArray = str.split(",");
            List<Integer> result = new ArrayList<>();
            result.add(Integer.parseInt(tempArray[0]));
            result.add(Integer.parseInt(tempArray[1]));
            result.add(Integer.parseInt(tempArray[2]));
            result.add(Integer.parseInt(tempArray[3]));
            resultList.add(result);
        }
        return resultList;
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);

        int last = 0;
        String lastResult = "";
        int cur = 0;
        String curResult = "";
        for(int i=0; i<words.length; i++){
            if(curResult.equals(words[i].substring(0, words[i].length()-1))){
                cur++;
                curResult = words[i];
            }else {
                if(cur == last && curResult.compareTo(lastResult) < 0){
                    lastResult = curResult;
                    last = cur;
                }else if (cur > last){
                    lastResult = curResult;
                    last = cur;
                }

                cur = 1;
                curResult =  words[i];
            }
        }

        if(cur == last && curResult.compareTo(lastResult) < 0){
            lastResult = curResult;
            last = cur;
        }else if (cur > last){
            lastResult = curResult;
            last = cur;
        }

        return lastResult;
    }


    public static double averageHeight(TreeNode r){
        if(r == null){
            return  0.0d;
        }

        List<List<TreeNode>> resultList = new ArrayList<>();
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(r);
        resultList.add(rootList);

        while(!resultList.isEmpty()){
            Iterator<List<TreeNode>> iterator = resultList.iterator();
            boolean add = false;
            List<List<TreeNode>> tempResultList = new ArrayList<>();
            while(iterator.hasNext()){
                List<TreeNode> tempList = iterator.next();
                TreeNode node =  tempList.get(tempList.size()-1);
                if(node.left == null && node.right == null){
                    continue;
                }

                add = true;
                iterator.remove();

                if(node.left != null){
                    List<TreeNode> left = new ArrayList<>(tempList);
                    left.add(node.left);
                    tempResultList.add(left);
                }
                if(node.right != null){
                    List<TreeNode> right = new ArrayList<>(tempList);
                    right.add(node.right);
                    tempResultList.add(right);
                }
            }

            resultList.addAll(tempResultList);
            if(!add){
                break;
            }
        }

        long pathTotal =  resultList.size();
        long pathElementTotal = resultList.stream().flatMap(Collection::stream).count();

        return pathElementTotal*1.0/pathTotal;
    }

    public static double averageHeight2(TreeNode r){
        List<List<TreeNode>> resultList = travel(r);

        long pathTotal =  resultList.size();
        long pathElementTotal = resultList.stream().flatMap(Collection::stream).count();

        return pathElementTotal*1.0/pathTotal;
    }

    public static List<List<TreeNode>> travel(TreeNode r){
        if(r == null){
            return new ArrayList<>();
        }

        List<List<TreeNode>> leftList = travel(r.left);
        List<List<TreeNode>> rightList = travel(r.right);

        if(leftList.isEmpty() && rightList.isEmpty()){
            List<TreeNode> temp = new ArrayList<>();
            temp.add(r);

            List<List<TreeNode>> result = new ArrayList<>();
            result.add(temp);
            return result;
        }

        List<List<TreeNode>> resultList = new ArrayList<>();

        if(!leftList.isEmpty()){
            for (List<TreeNode> treeNodes : leftList) {
                treeNodes.add(r);
            }

            resultList.addAll(leftList);
        }

        if(!rightList.isEmpty()){
            for (List<TreeNode> treeNodes : rightList) {
                treeNodes.add(r);
            }
            resultList.addAll(rightList);
        }

        return resultList;
    }
}



