package lesson07.file;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\lesson07");

        System.out.println("File name " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Parent directory: " + file.getParent());
        System.out.println(file.canWrite() ? "Possible to edit" : "Impossible to edit");
        System.out.println(file.canRead() ? "Possible to read" : "Impossible to read");
        System.out.println((file.isDirectory() ? "Is dir" : "Isn't dir"));
        System.out.println(file.isFile() ? "Is file" : "Isn't file");
        System.out.println("Last modification date: " + file.lastModified());
        System.out.println("Size: " + file.length() + " byte.");

        showDirFilling(file);
    }

    private static void showDirFilling(File file) {
        if (file.isDirectory()) {
            System.out.println("Dir " + file);
            String[] internalObjects = file.list();
            if (internalObjects != null) {
                for (String internalObject : internalObjects) {
                    File internal = new File(file, internalObject);
                    if (internal.isDirectory()) {
                        System.out.printf("\t%s dir %n", internalObject);
                    } else {
                        System.out.printf("\t%s file %n", internalObject);
                    }
                }
            }
        }
    }
}