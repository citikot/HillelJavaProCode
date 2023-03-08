package lesson07.xml.json;

/**
 * @author spasko
 */

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "Group")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"room", "teacher", "students", "humanResources"})
public class Group implements Serializable {

    @XmlElement(type = Teacher.class)
    private Person teacher;
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({@JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
            @JsonSubTypes.Type(value = Student.class, name = "student")})
    private List<Person> students;
    @XmlElement(required = true, nillable = false)
    private Room room;
    @XmlElementWrapper(name = "hrs")
    @XmlElement(name = "humanResource")
    private Set<HumanResource> humanResources;
    private int id;

    public Group(Teacher teacher, List<Person> students, Room room, Set<HumanResource> humanResources) {
        this.teacher = teacher;
        this.students = students;
        this.room = room;
        this.humanResources = humanResources;
    }

    public Group() {
    }

    public Person getTeacher() {
        return teacher;
    }

    @XmlElement
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<HumanResource> getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(Set<HumanResource> humanResources) {
        this.humanResources = humanResources;
    }

    @Override
    public String toString() {
        return "Group [teacher=" + teacher + ", students=" + students + ", room=" + room + ", humanResources="
                + humanResources + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Group groupExampleCreator() {
        Group group = new Group();
        group.setId(18122018);

        Teacher teacher = new Teacher("Serhii", "Pasko", 1988, 666);
        group.setTeacher(teacher);

        Room room = new Room("Kiyv", "Tarasivska", 16, 28);
        group.setRoom(room);

        Set<HumanResource> humanResources = new HashSet<>();
        humanResources.add(new HumanResource("Karmen", "", 1990, 2015));
        humanResources.add(new HumanResource("Efiria", "", 1989, 2016));
        group.setHumanResources(humanResources);

        List<Person> students = new ArrayList<>();
        students.add(new Student("Iza", "Rabinovish", 1997));
        students.add(new Student("Abram", "Kolom", 1998));
        students.add(new Teacher("Moisha", "Stefan", 1990, 666));
        group.setStudents(students);

        return group;
    }

}
