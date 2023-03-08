package lesson32.soap;

import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import lesson07.xml.json.Person;
import lesson07.xml.json.Student;
import lesson07.xml.json.Teacher;

/**
 * @author spasko
 */
public class MainGroupClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9999/group?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap.lesson32/", "GroupServiceImplService");

		Service service = Service.create(url, qname);

		GroupService hello = service.getPort(GroupService.class);

		System.out.println(hello.getGroup(18122018));

		List<Person> persons = new ArrayList<>();
		persons.add(new Student("First", "First", 1995));
		persons.add(new Teacher("Second", "Second", 1990, 666));
		System.out.println(hello.addStudents(18122018, persons));
	}

}