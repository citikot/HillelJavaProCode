package lesson18.stream.source;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MainStreamSources {
    public static void main(String[] args) {
        // Create a stream from specified values
        Stream<String> stream = Stream.of("a", "b", "c");
        printStream(1, stream);

        // Get the array
        String[] array = {"a", "b", "c"};
        // Get the Stream from the Array
        stream = Arrays.stream(array);
        printStream(2, stream);

        // Empty stream
        stream = Stream.empty();
        printStream(3, stream);

        // Create stream using Stream builder()
        Stream.Builder<String> builder = Stream.builder();
        // Adding elements in the stream of Strings
        stream = builder.add("a")
                .add("b")
                .add("c")
                .build();
        printStream(4, stream);

        // Create infinite stream
        // using Stream.iterate() method
        stream = Stream.iterate("a", element -> String.valueOf((char) (element.charAt(0) + 1)))
                .limit(3);
        printStream(5, stream);

        // using Stream.generate() method
        stream = Stream.generate(() -> String.valueOf((char) (new Random().nextInt(65, 68))))
                .limit(3);
        printStream(6, stream);

        // Get the Iterable
        Iterable<String> iterable = Arrays.asList("a", "b", "c");
        // Convert the iterator into a Stream
        stream = StreamSupport.stream(iterable.spliterator(), false);
        printStream(7, stream);

        // From collection
        Collection<String> collection = List.of("a", "b", "c");
        stream = collection.stream();
        printStream(8, stream);

        Map<String, String> map = Map.of("a", "a", "b", "b", "c", "c");
        Stream<?> entrySetStream = map.entrySet()
                .stream();
        printStream(9, entrySetStream);
    }

    private static <T> void printStream(int number, Stream<T> stream) {
        System.out.print(number + ": ");
        stream.forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}
