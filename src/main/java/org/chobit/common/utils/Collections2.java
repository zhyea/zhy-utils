package org.chobit.common.utils;

import org.chobit.common.model.Pair;

import java.util.*;

/**
 * 集合操作辅助类
 *
 * @author robin
 */
public final class Collections2 {

    /**
     * 判断集合是否为空
     *
     * @param coll 目标集合
     * @return 集合是否为空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return null == coll || coll.isEmpty();
    }

    /**
     * 判断Map是否为空
     *
     * @param map 目标集合
     * @return Map是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }


    /**
     * 根据提供的元素创建列表
     *
     * @param elements 列表元素
     * @param <T>      列表元素类型
     * @return 新建的列表
     */
    public static <T> List<T> listOf(T... elements) {
        List<T> list = new LinkedList<>();
        if (null == elements) {
            return list;
        }
        Collections.addAll(list, elements);
        return list;
    }


    /**
     * 取出集合中的第一个元素
     *
     * @param coll 集合
     * @param <T>  集合元素类型
     * @return 集合中的第一个元素。如集合为空返回null
     */
    public static <T> T first(Collection<T> coll) {
        if (isEmpty(coll)) {
            return null;
        }
        return coll.iterator().next();
    }


    /**
     * 将Pair集合转为Map对象
     *
     * @param pairs Pair集合
     * @param <K>   Key 类型
     * @param <V>   Value 类型
     * @return Map对象
     */
    public static <K, V> Map<K, V> toMap(Collection<Pair<K, V>> pairs) {
        Map<K, V> map = new HashMap<>(8);
        for (Pair<K, V> p : pairs) {
            map.put(p.getKey(), p.getValue());
        }
        return map;
    }


    /**
     * 将Map对象转为Pair集合
     *
     * @param map Map对象
     * @param <K> Key类型
     * @param <V> Value类型
     * @return Pair集合
     */
    public static <K, V> List<Pair<K, V>> toPairs(Map<K, V> map) {
        List<Pair<K, V>> result = new LinkedList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        return result;
    }


    /**
     * 将key和value放入一个map实例中
     *
     * @param key   key的值
     * @param value value的值
     * @param <K>   Key类型
     * @param <V>   Value类型
     * @return Map对象
     */
    public static <K, V> Map<K, V> mapOf(K key, V value) {
        Map<K, V> map = new HashMap<>(1);
        map.put(key, value);
        return map;
    }


    /**
     * 拼接集合数据为字符串
     *
     * @param coll      集合
     * @param separator 分隔符
     * @param <T>       集合数据类型
     * @return 集合数据对应的字符串
     */
    public static <T> String join(Collection<T> coll, String separator) {
        if (isEmpty(coll)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (T t : coll) {
            if (builder.length() > 0) {
                builder.append(separator);
            }
            builder.append(t.toString());
        }
        return builder.toString();
    }


    private Collections2() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
