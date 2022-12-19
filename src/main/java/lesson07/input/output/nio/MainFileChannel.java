package lesson07.input.output.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class MainFileChannel {
    public static void main(String args[]) throws IOException {
        //append the content to existing file 
        writeFileChannel(ByteBuffer.wrap("Welcome to TutorialsPoint".getBytes()));
        //read the file
        readFileChannel();
    }

    public static void readFileChannel() throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("src\\main\\resources\\lesson07\\input.txt",
                "rw"); FileChannel fileChannel = randomAccessFile.getChannel();) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            Charset charset = Charset.forName("US-ASCII");
            while (fileChannel.read(byteBuffer) > 0) {
                byteBuffer.rewind();
                System.out.print(charset.decode(byteBuffer));
                byteBuffer.flip();
            }
        }
    }

    public static void writeFileChannel(ByteBuffer byteBuffer) throws IOException {
        Set<StandardOpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);
        Path path = Paths.get("src\\main\\resources\\lesson07\\output.txt");
        try (FileChannel fileChannel = FileChannel.open(path, options);) {
            fileChannel.write(byteBuffer);
        }
    }
}
