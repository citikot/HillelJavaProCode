package lesson13.multithreading.singleton;

/**
 * @author spasko
 */
public class S4ThreadSafeSingleton {
	private static S4ThreadSafeSingleton instance;

	private S4ThreadSafeSingleton() {
	}

	public static synchronized S4ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new S4ThreadSafeSingleton();
		}
		return instance;
	}
}
