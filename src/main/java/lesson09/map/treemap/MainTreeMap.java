package lesson09.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class MainTreeMap {
    public static void main(String[] args) {

        TreeMap<Integer, String> days = new TreeMap<>();
        days.put(7, "Sunday");
        days.put(3, "Wednesday");
        days.put(4, "Thursday");
        days.put(1, "Monday");
        days.put(2, "Tuesday");
        days.put(5, "Friday");
        days.put(6, "Saturday");

        for (Map.Entry<Integer, String> entry : days.entrySet()) {
            System.out.println("1: " + entry.getKey() + " " + entry.getValue());
        }

        System.out.println("2: " + days.subMap(3, 6));
        
        days.remove(5);
        System.out.println("3: " + days.higherEntry(4));

        System.out.println("4: " + days.ceilingEntry(4));
        
        System.out.println("5: " + days.lowerEntry(6));

        days.clear();
        System.out.println("2: After clear: " + days.size());
    }
}
