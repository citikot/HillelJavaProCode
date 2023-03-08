package lesson07.xml.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * @author spasko
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student extends Person {

    @Override
    @XmlTransient
    @JsonIgnore
    public String getSurname() {
        return super.getSurname();
    }

    public Student() {

    }

    public Student(String name, String surname, int yearOfBorn) {
        super(name, surname, yearOfBorn);
    }

}
