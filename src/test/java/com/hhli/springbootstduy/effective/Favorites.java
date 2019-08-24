package com.hhli.springbootstduy.effective;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/8/22 9:03
 * @description 异构容器测试
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance){
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
