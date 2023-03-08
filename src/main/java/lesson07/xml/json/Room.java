package lesson07.xml.json;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * @author spasko
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Room implements Serializable {
    @XmlAttribute
    private String city;
    @XmlAttribute
    private String street;
    private int house;
    private int number;

    public Room() {
    }

    public Room(String city, String street, int house, int number) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Room [city=" + city + ", street=" + street + ", house=" + house + ", number=" + number + "]";
    }

}
