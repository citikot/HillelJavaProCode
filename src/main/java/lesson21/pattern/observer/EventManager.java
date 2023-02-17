package lesson21.pattern.observer;

// Implemented by Cricket data to communicate
// with observers
public interface EventManager {
    public void registerObserver(Observer o);

    public void unregisterObserver(Observer o);

    public void notifyObservers();
}