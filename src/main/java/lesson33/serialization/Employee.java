package lesson33.serialization;

import java.io.Serializable;

//If we implement Serializable, then we can convert this class instance into stream of bytes
public class Employee implements Serializable {

    // This serialVersionUID field is to verify that the saved and loaded objects
    // have the same attributes
    private static final long serialVersionUID = 2L;

    // instance variables get serialized
    // deserialization assign the serialized value
    private int employeeId;
    private String name;

    // transient variables will not be serialized
    // deserialization assign default value, here it is 0.0
    private transient double salary;

    // static variables will not be serialized
    // Since static variables belongs to the class. After de-serialization they get
    // their current values from the loaded class.
    private static String designation;

    // final variables will get serialized
    // deserialization process do not invoke the constructor, but still
    // deserialization process assign value to this final private variable
    private final String department;

    // Constructor won't be invoked in the deserialization
    public Employee(int employeeId, String name, double salary, String designation, String department) {
        System.out.println("------------Contructor------------");
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        Employee.designation = designation;// Since it is static,it is not part of Object
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", designation="
                + designation + ", department=" + department + "]";
    }

    // Setters & Getters

}
