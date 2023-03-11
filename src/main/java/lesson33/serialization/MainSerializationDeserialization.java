package lesson33.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainSerializationDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee empObj = new Employee(1001, "Serhii", 123, "Architect", "IT");
        System.out.println("Before serialization  => " + empObj.toString());
        // Serialization
        serialize(empObj);
        // Deserialization
        Employee deserialisedEmpObj = deserialize();
        System.out.println("After deserialization => " + deserialisedEmpObj.toString());
    }

    // Serialization code
    private static void serialize(Employee empObj) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("Employee.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(empObj);
        }
    }

    // Deserialization code
    private static Employee deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("Employee.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Employee) ois.readObject();
        }
    }

}