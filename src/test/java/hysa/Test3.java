package hysa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> m = new HashMap<>();
        for (String product : products) {
            m.put(product, m.getOrDefault(product, 0) + 1);
        }

        List<String> uniqueNumbers = new ArrayList<>();
        for (String key : m.keySet()) {
            if (m.get(key) == 1) return key;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}
