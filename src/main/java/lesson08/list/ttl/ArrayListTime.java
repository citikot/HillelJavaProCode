package lesson08.list.ttl;

/**
 * @author spasko
 */

import java.util.ArrayList;

public class ArrayListTime<T> extends ArrayList<DummyForTime<T>> {
    private Long timeToLive;

    public ArrayListTime(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Long getTimeToLive() {
        return timeToLive;
    }

    @Override
    public DummyForTime<T> get(int index) {
        super.removeIf(dummyForTime -> (System.currentTimeMillis() - dummyForTime.getTimeCreation()) >= timeToLive);
        return super.get(index);
    }

    @Override
    public int indexOf(Object o) {
        super.removeIf(dummyForTime -> (System.currentTimeMillis() - dummyForTime.getTimeCreation()) >= timeToLive);
        return super.indexOf(o);
    }

    @Override
    public int size() {
        super.removeIf(dummyForTime -> (System.currentTimeMillis() - dummyForTime.getTimeCreation()) >= timeToLive);
        return super.size();
    }
}
