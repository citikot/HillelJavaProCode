package lesson09.map.linkedhashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainLinkedHashMap {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("Basil", "07.12.1987");
        hashMap.put("Kate", "12.10.1971");
        hashMap.put("Lena", "11.01.1991");
        System.out.println("1: " + hashMap);

        Map<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("Basil", "07.12.1987");
        linkedHashMap.put("Kate", "12.10.1971");
        linkedHashMap.put("Lena", "11.01.1991");
        System.out.println("2: " + linkedHashMap);

        System.out.println("3: " + linkedHashMap.get("Kate"));
        System.out.println("4: " + linkedHashMap);

        Map<String, String> linkedHashMap2 = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap2.put("Basil", "07.12.1987");
        linkedHashMap2.put("Kate", "12.10.1971");
        linkedHashMap2.put("Lena", "11.01.1991");
        System.out.println("5: " + linkedHashMap2);

        System.out.println("6: " + linkedHashMap2.get("Kate"));
        System.out.println("7: " + linkedHashMap2);

    }

}
