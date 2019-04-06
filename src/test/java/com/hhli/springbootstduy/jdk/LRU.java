package com.hhli.springbootstduy.jdk;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 李辉辉
 * @date 2019/3/24 10:35
 * @description
 */
public class LRU <K, V> extends LinkedHashMap<K,V> implements Map<K, V> {

    private static final long serialVersionUID = 3614163282884485214L;

    /**
     * 数据最大容量
     */
    private static final int THRESHOLD = 6;

    public LRU(int initialCapacity, float loadFactor){
        super(initialCapacity, loadFactor, Boolean.TRUE);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size()> 6;
    }

    public static void main(String[] args) {
        LRU<Character, Integer> lru = new LRU<>(16, 0.75F);

        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }

        System.out.println("LRU中key为a的entry的值为：" + lru.get('a'));
        System.out.println("LRU中key为h的entry的值为：" + lru.get('h'));
        System.out.println("LRU的大小为" + lru.size());
        System.out.println("LRU：" + lru);
    }
}
