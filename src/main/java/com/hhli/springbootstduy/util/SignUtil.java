package com.hhli.springbootstduy.util;

import com.hhli.springbootstduy.exception.CustomerException;
import com.hhli.springbootstduy.model.enums.CodeEnum;
import com.hhli.springbootstduy.model.enums.ParamEnum;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

public class SignUtil {

    private SignUtil() {

    }

    public static String genRequestInSign(Map<String, String> data, String secret) throws
            CustomerException {
        if (null == data || 0 == data.size()) {
            throw new CustomerException(CodeEnum.SIGN_ERROR, "请求参数为空，无法生成加密串");
        }


        Map<String, String> sortData = sortMapByKey(data);

        if (null == sortData || sortData.isEmpty()) {
            throw new CustomerException(CodeEnum.SIGN_ERROR, "请求参数为空，无法生成加密串");
        }

        StringBuilder signStr = new StringBuilder();

        for (String key : sortData.keySet()) {
            if (key.equals(ParamEnum.SIGN.getParamName())) {
                //签名字段不参与签名生成
                continue;
            }
            String urlEncodeStr;
            try {
                urlEncodeStr = URLEncoder.encode(sortData.get(key), "utf-8");
            } catch (Exception e) {
                throw new CustomerException(CodeEnum.SIGN_ERROR, key + "对应的只 urlencode 失败");
            }
            if (signStr.length() > 0) {
                signStr.append("&");
            }
            signStr.append(key).append("=").append(urlEncodeStr);
        }

        signStr.append(secret);
        return StringUtil.getMd5String(signStr.toString(), "");
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<String, String> sortMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        sortMap.putAll(map);

        return sortMap;
    }


    public static String getBigDataSign(Map<String, String> params, String secretKey) throws
            UnsupportedEncodingException, NoSuchAlgorithmException {
        return getSign(getSign(getSignStr(params, "").toLowerCase()).toLowerCase() + secretKey).toLowerCase();
    }


    public static String getSignStr(Map<String, String> params, String secretKey)
            throws UnsupportedEncodingException {
        if (params.isEmpty()) {
            return "";
        }
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            String value = String.valueOf(params.get(key));
            if (null != key && null != value) {
                sb.append(key).append("=").append(URLEncoder.encode(value, "UTF-8")).append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        if (!StringUtils.isEmpty(secretKey)) {
            sb.append(secretKey);
        }
        return sb.toString();
    }

    public static String getSign(String data)
            throws NoSuchAlgorithmException {
        if (StringUtils.isBlank(data)) {
            return "";
        }

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return byte2hex(md5.digest(data.getBytes(StandardCharsets.UTF_8)));
    }

    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void BubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void InsertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while(j> 0 && temp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            if(i != j){
                array[j] =  temp;
            }
        }
    }

    public static  int[]  CombineSort(int[] sourceArray){
        if(sourceArray == null || sourceArray.length <=1) {
            return sourceArray;
        }
        int mid = (int) Math.floor(sourceArray.length/2.0);
        int[] left = Arrays.copyOfRange(sourceArray, 0, mid);
        int[] right = Arrays.copyOfRange(sourceArray, mid, sourceArray.length);

        return merge(CombineSort(left), CombineSort(right));
    }

    public static int[] merge(int[] left, int[] right){
        int[] temp = new int[left.length + right.length];

        int i = 0, j = 0, m = 0;
        while(i< left.length && j<right.length){
            if(left[i] < right[j]){
                temp[m] =  left[i];
                i++;
            }else{
                temp[m] =  right[j];
                j++;
            }
            m++;
        }

        for(; i<left.length;i++, m++){
            temp[m] =  left[i];
        }

        for(; j<right.length;j++, m++){
            temp[m] =  right[j];
        }

        return temp;
    }

    public  static void QuickSort(int[] array){
        if(array == null || array.length == 1){
            return ;
        }

        QuickSort(array, 0, array.length-1);
    }

    public  static void QuickSort(int[] array, int left, int right){
        if(left < right){
            int partitionIndex =  partition(array, left, right);
            QuickSort(array, left, partitionIndex-1);
            QuickSort(array, partitionIndex+1, right);
        }
    }

    public static int partition(int[] array, int left, int right){
        int pivot = left;
        int index = left +1;
        for (int i = index; i <= right; i++) {
            if(array[i] < array[pivot]){
                int temp =  array[i];
                array[i] =  array[index];
                array[index] = temp;
                index++;
            }
        }

        int temp =  array[index-1];
        array[index-1] =  array[pivot];
        array[pivot] = temp;
        return index-1;
    }

    public static void main(String[] args) {
//        ListNode l11 = new ListNode(-9);
//        ListNode l12 = new ListNode(3);
//        l11.next = l12;
////        ListNode l13 = new ListNode(9);
////        l12.next =  l13;
//
//
//        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(7);
//        l21.next = l22;
////        ListNode l23 = new ListNode(4);
////        l22.next = l23;
//        long start = System.currentTimeMillis();
//        mergeTwoLists(l11, l21);
//        System.out.println((System.currentTimeMillis() - start) + "ms");
//
//        int[] array = new int[]{8, 2, 6, 9, 10};
//        QuickSort(array);
//        System.out.println(Arrays.toString(array));
//
//        int[] nums = new int[1];
//        ThreadLocal<String> localStr = new ThreadLocal<>();
//        localStr.set("test");
//        MDC.put("", "");
//        LRUCache cache = new LRUCache(2);
//        cache.put(2, 1);
//        cache.put(1, 1);
//        cache.put(2, 3);
//        cache.put(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        System.out.println(orderlyQueue("asfbbr", 2));
    }


    public static String toGoatLatin(String sentence) {
        String [] tempArray = sentence.split(" ");
        StringBuilder temp = new StringBuilder("maa");
        for (int i = 0; i < tempArray.length; i++) {
            String s = tempArray[i];
            switch (s.charAt(0)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    s = s + temp;
                    break;
                default:
                    s = s.substring(1) + s.charAt(0) + temp;
            }
            temp.append("a");
            tempArray[i] = s;
        }

        return String.join(" ", tempArray);
    }

    public static List<Integer> frontReserve(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            }

            root = stack.pop();
        }

        return  res;
    }

    public static List<Integer> middleReserve(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode temp = stack.pop();
            res.add(temp.val);
            root = temp.right;
        }

        return res;
    }

    public static void backReserve(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null){

        }
    }

    public static String orderlyQueue(String s, int k) {
        if(k == 1){
            String t  = s;
            for(int i=0; i<s.length(); i++){
                s = s.charAt(0) + s.substring(1);
                if(s.compareTo(t) < 0) {
                    t = s;
                }
            }
            return t;
        }else {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        }
    }
}



class LRUCache {
    private  int capacity;
    private Map<Integer, Integer> numMap;
    private final List<Integer> numList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.numMap = new HashMap<>();
        this.numList = new ArrayList<>();
    }

    public int get(int key) {
        Integer t = key;
        if(this.numMap.containsKey(t)){
            numList.remove(t);
            numList.add(t);
            return this.numMap.get(t);
        }

        return -1;
    }

    public void put(int key, int value) {
        if(this.numMap.containsKey(key)){
            Integer t = key;
            numList.remove(t);
            numList.add(t);
        }else {
            numList.add(key);
        }
        numMap.put(key, value);
        if(numMap.size() > this.capacity){
            Integer tempKey = numList.remove(0);
            this.numMap.remove(tempKey);
        }
    }

    public Map<Integer, Integer> getNumMap() {
        return numMap;
    }

    public void setNumMap(Map<Integer, Integer> numMap) {
        this.numMap = numMap;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
  }
}