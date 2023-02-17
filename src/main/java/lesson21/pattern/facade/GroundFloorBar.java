package lesson21.pattern.facade;

import java.util.Map;

public class GroundFloorBar implements Bar {
    @Override
    public Map<String, Integer> getVineCard() {
        return Map.of("Proseco", 1965);
    }
}
