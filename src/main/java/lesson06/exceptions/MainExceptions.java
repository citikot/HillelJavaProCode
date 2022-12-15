package lesson06.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainExceptions {
    public static void main(String[] args) {
        Calculator.div(12, 0);

        //Calculator.sqrt(9);

        //Calculator.acos(-2);

        //try {
        //    Calculator.sqrt(-4);
        //} catch (Exception e) {
        //    System.out.println("Exception was handled");
        //} catch (NegativeValueException e) {
        //    System.out.println("NegativeValueException was handled");
        //}

        //try {
        //    Calculator.asin(3);
        //} catch (InvalidTrygonometryException | IllegalArgumentException e) {
        //    System.out.println(e.getClass()
        //    .getSimpleName() + " was handled");
        //}

        //try {
        //    Calculator.sqrt(-1);
        //} catch (Exception e) {
        //    System.out.println("Exception was handled");
        //} finally {
        //    System.out.println("Not important do we have an exception or not. ruzzia must be destroy");
        //}

        //try (FileReader fileReader = new FileReader("src\\main\\resources\\lesson06\\input.txt");
        //        BufferedReader bufferedReader = new BufferedReader(fileReader);) {
        //    String line = null;
        //    while ((line = bufferedReader.readLine()) != null) {
        //        System.out.println("--> " + line);
        //    }
        //
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    }

}
