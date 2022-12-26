package lesson09.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MainHashMap {
    public static void main(String[] args) {
        mapMethodsJava7();

        mapMethodsJava8();
    }

    private static void mapMethodsJava7() {
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("Basil", "07.12.1987");
        hashMap.put("Kate", "12.10.1971");
        hashMap.put("Lena", "11.01.1991");
        System.out.println("1: " + hashMap);

        hashMap.put("Lena", "10.21.1992");
        System.out.println("2: " + hashMap);

        System.out.println("3: The value for 'Basil' is " + hashMap.get("Basil"));

        hashMap.remove("Kate");
        System.out.println("4: " + hashMap);

        System.out.println("5: Do we have 'Basil'? " + hashMap.containsKey("Basil"));

        System.out.println("6: Do we have a value'12.10.1971'? " + hashMap.containsValue("12.10.1971"));

        System.out.println("7: The size of map is " + hashMap.size());

        hashMap.put(null, "10.21.1992");
        hashMap.put("Victoria", null);
        hashMap.keySet()
                .forEach(key -> System.out.println("8: " + key));

        hashMap.entrySet()
                .forEach(entry -> System.out.println("9: key=" + entry.getKey() + " value=" + entry.getValue()));

        hashMap.values()
                .forEach(value -> System.out.println("10: " + value));
    }

    private static void mapMethodsJava8() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Basil", "07.12.1987");
        hashMap.put("Kate", "12.10.1971");
        hashMap.put("Lena", "11.01.1991");
        System.out.println("11: " + hashMap);

        hashMap.putIfAbsent("Lena", "11.11.2011");
        hashMap.putIfAbsent("Svitlana", "12.12.2012");
        System.out.println("11: " + hashMap);

        hashMap.computeIfPresent("Kate", (key, value) -> key + "***" + value);
        hashMap.computeIfPresent("Jon", (key, value) -> key + "***" + value);
        System.out.println("12: " + hashMap);

        hashMap.computeIfAbsent("Kate", key -> key + "+++");
        hashMap.computeIfAbsent("Jon", key -> key + "+++");
        System.out.println("13: " + hashMap);

        hashMap.remove("Jon", "Jon+++");
        System.out.println("14: " + hashMap);

        System.out.println("15: " + hashMap.getOrDefault("Maria", "09.09.2009"));
        System.out.println("16: " + hashMap.getOrDefault("Basil", "07.07.2007"));

        hashMap.merge("Ola", "01.01.2001", (oldValue, newValue) -> oldValue + "---" + newValue);
        hashMap.merge("Basil", "01.01.2001", (oldValue, newValue) -> oldValue + "---" + newValue);
        System.out.println("17: " + hashMap);
    }
}
