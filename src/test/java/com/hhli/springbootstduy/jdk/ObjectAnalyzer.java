package com.hhli.springbootstduy.jdk;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/5/22 8:17
 * @description 通用的toString方法
 */
public class ObjectAnalyzer {

    /**
     * 避免循环引用的情况
     */
    private List<Object> visited = new ArrayList<>();

    public String toString(Object object)  {
        if(object == null) return "null";
        if(visited.contains(object)) return  "....";

        visited.add(object);

        Class c1 = object.getClass();
        if(c1 == String.class) return (String)object;
        if(c1.isArray()){
            String r = c1.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(object); i++) {
                if(i>0) r  += ",";
                Object val = Array.get(object, i);
                if(c1.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = c1.getName();
        do{
            r += "[";
            Field[] fields = c1.getDeclaredFields();
            AccessibleObject.setAccessible(fields, Boolean.TRUE);
            for (Field field : fields) {
                if(!Modifier.isStatic(field.getModifiers())){
                    if(!r.endsWith("[")) r +=",";
                    r += field.getName() + "=";
                    try {
                        Class c = field.getType();
                        Object val = field.get(object);

                        if(c.isPrimitive())  r += val;
                        else r+= toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r+="]";
            c1 = c1.getSuperclass();
        }while (c1 == null);

        return r;
    }
}
