package lesson32.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import java.util.List;
import lesson07.xml.json.Group;
import lesson07.xml.json.Person;

/**
 * @author spasko
 */
// Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface GroupService {

    @WebMethod
    public Group getGroup(Integer groupId);

    @WebMethod
    public Group addStudents(Integer groupId, List<Person> persons);
}