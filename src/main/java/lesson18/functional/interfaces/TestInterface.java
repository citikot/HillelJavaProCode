package lesson18.functional.interfaces;

/**
 * @author spasko
 */
@FunctionalInterface
public interface TestInterface<T, V> {
	V doSome(T t);
}
