package lesson20.annotation.repeatable;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MainRepeatableAnnotation {

    @Student(name = "Stepan")
    @Student(name = "Oleg")
    @Student
    public static void newMethod() {
        System.out.println("Something");
    }

    public static void main(String[] args) {

        try {
            Method method = MainRepeatableAnnotation.class.getMethod("newMethod");

            // Display the repeated annotation
            Students students = method.getAnnotation(Students.class);
            Arrays.stream(students.value())
                    .map(Student::name)
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
