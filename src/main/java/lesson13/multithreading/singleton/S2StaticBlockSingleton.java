package lesson13.multithreading.singleton;

/**
 * @author spasko
 */
public class S2StaticBlockSingleton {

	private static S2StaticBlockSingleton instance;

	private S2StaticBlockSingleton() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new S2StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static S2StaticBlockSingleton getInstance() {
		return instance;
	}
}
