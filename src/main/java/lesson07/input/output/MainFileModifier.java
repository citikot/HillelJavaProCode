package lesson07.input.output;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * @author spasko
 */
public class MainFileModifier {

    public static void main(String[] args) {

        try (Scanner keyboard = new Scanner(System.in)) {

            System.out.print("Enter the input file name: ");
            String fileToRead = keyboard.nextLine();

            System.out.print("Enter the output file name: ");
            String outputFileName = keyboard.nextLine();

            Path inputPath = Paths.get("src\\main\\resources\\lesson07\\" + fileToRead);
            List<String> fileLines = java.nio.file.Files.readAllLines(inputPath);

            List<String> linesToUpperCase = fileLines.stream()
                    .map(String::toUpperCase)
                    .map(s -> s.replace("S", "!!!!"))
                    .toList();

            Path outputPath = Paths.get("src\\main\\resources\\lesson07\\" + outputFileName);
            java.nio.file.Files.write(outputPath, linesToUpperCase, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
            System.out.println("Done!!!");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
