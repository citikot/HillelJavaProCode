package lesson11.generic.erasure;

public class ValueStorage<T> {
    T value;

//    public void setIntValue(Object object) {
//        value = (T) object;
//    }

    public void setIntValue(T t) {
        value = t;
    }
}
