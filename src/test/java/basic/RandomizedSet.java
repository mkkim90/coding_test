package basic;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    int size;

    public RandomizedSet() {
        map = new HashMap<>();
        size = 0;
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, size++);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        map.remove(val);
        if (idx != size -1) {
            int swap = list.get(size -1);
            list.set(idx, swap);
            map.put(swap, idx);
        }
        list.remove(--size);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt();
        return list.get(idx);
    }

}
