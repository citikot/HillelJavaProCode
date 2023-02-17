package lesson21.pattern.observer;

// This interface is implemented by all those
// classes that are to be updated whenever there
// is an update from CricketData
public interface Observer {
    public void update(int runs, int wickets, float overs);
}