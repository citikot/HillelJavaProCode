package lesson21.pattern.observer;

import java.util.ArrayList;
import java.util.Random;

public class CricketData implements EventManager {
    private int runs;
    private int wickets;
    private float overs;
    private ArrayList<Observer> observerList = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(runs, wickets, overs));
    }

    // get latest runs from stadium
    private int getLatestRuns() {
        return random.nextInt(80, 90);
    }

    // get latest wickets from stadium
    private int getLatestWickets() {
        return random.nextInt(5);
    }

    // get latest overs from stadium
    private float getLatestOvers() {
        return random.nextFloat(5.4F, 11.8F);
    }

    // This method is used update displays
    // when data changes
    public void dataChanged() {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        notifyObservers();
    }
}