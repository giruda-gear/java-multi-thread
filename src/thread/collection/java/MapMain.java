package thread.collection.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapMain {

    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(3, "data-3");
        map.put(2, "data-2");
        map.put(1, "data-1");
        System.out.println("map = " + map);
    }
}
