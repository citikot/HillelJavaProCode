package lesson18.functional.interfaces;

import java.util.Comparator;

/**
 * @author spasko
 */
public class MainLambdaBasics {
    public static void main(String[] args) {
        TestInterface<Integer, String> testInterface = new TestInterface<Integer, String>() {
            @Override
            public String doSome(Integer t) {
                return "Number1: " + t;
            }
        };
        System.out.println("1: " + testInterface.doSome(123));

        testInterface = (Integer t) -> "Number2: " + t;
        System.out.println("2: " + testInterface.doSome(123));

        testInterface = (t) -> "Number3: " + t;
        System.out.println("3: " + testInterface.doSome(123));

        testInterface = t -> "Number4: " + t;
        System.out.println("4: " + testInterface.doSome(123));

        testInterface = t -> "Number5: dont use param";
        System.out.println("5: " + testInterface.doSome(123));

        testInterface = i -> i.toString();
        System.out.println("6: " + testInterface.doSome(123));

        testInterface = t -> ((Object) t).toString();
        System.out.println("7: " + testInterface.doSome(234));

        testInterface = Object::toString;
        System.out.println("8: " + testInterface.doSome(234));

        doReaction(t -> "Number" + t);

        Comparator<String> exampleComparator = (firstString, secondString) -> {
            if (firstString.length() > 3) {
                return firstString.compareTo(secondString);
            }
            return 0;
        };
    }

    public static <V> void doReaction(TestInterface<String, V> testInterface) {
        System.out.println(testInterface.doSome("123"));
    }
}
