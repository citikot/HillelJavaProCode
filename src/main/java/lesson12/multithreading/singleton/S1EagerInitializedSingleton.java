package lesson12.multithreading.singleton;

/**
 * @author spasko
 */
public class S1EagerInitializedSingleton {

	private static final S1EagerInitializedSingleton instance = new S1EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private S1EagerInitializedSingleton() {		
	}

	public static S1EagerInitializedSingleton getInstance() {
		return instance;
	}
}
