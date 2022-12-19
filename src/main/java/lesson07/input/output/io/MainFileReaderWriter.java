package lesson07.input.output.io;

import java.io.FileReader;
import java.io.FileWriter;

public class MainFileReaderWriter {
    public static void main(String[] args) {
        read();
        write();
    }

    private static void read() {
        try (FileReader fileReader = new FileReader("src\\main\\resources\\lesson07\\input.txt");) {

            System.out.println("Reading char by char : \n");
            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print((char) i);
            }

            System.out.println("Reading using array : \n");
            char[] charArray = new char[15];
            fileReader.read(charArray);
            System.out.print(charArray);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void write() {
        // initialize a string
        String str = "ABC";
        try (FileWriter fileWriter = new FileWriter("src\\main\\resources\\lesson07\\output.txt");) {

            // read each character from string and write
            // into FileWriter
            for (int i = 0; i < str.length(); i++)
                fileWriter.write(str.charAt(i));

            System.out.println("Successfully written");

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
