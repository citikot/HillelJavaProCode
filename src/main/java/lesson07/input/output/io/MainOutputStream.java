package lesson07.input.output.io;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainOutputStream {
    public static void main(String args[]) throws Exception {
        OutputStream output = new FileOutputStream("src\\main\\resources\\lesson07\\output.txt");
        byte b[] = {65, 66, 67, 68, 69, 70};

        // illustrating write(byte[] b) method
        output.write(b);

        // illustrating flush() method
        output.flush();

        // illustrating write(int b) method
        for (int i = 71; i < 75; i++) {
            output.write(i);
        }

        output.flush();

        // close the stream
        output.close();
    }
}
