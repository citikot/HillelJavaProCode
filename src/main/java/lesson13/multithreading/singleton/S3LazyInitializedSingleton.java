package lesson13.multithreading.singleton;

/**
 * @author spasko
 */
public class S3LazyInitializedSingleton {
	private static S3LazyInitializedSingleton instance;

	private S3LazyInitializedSingleton() {
	}

	public static S3LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new S3LazyInitializedSingleton();
		}
		return instance;
	}
}
