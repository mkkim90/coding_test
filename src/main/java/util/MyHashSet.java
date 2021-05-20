package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;


public class MyHashSet<E> {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }

    public MyHashSet(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }

    MyHashSet(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    public void clear() {
        map.clear();
    }

}