package lesson32.rest;

import jakarta.ws.rs.core.Response;
import lesson07.xml.json.Person;

/**
 * @author spasko
 */

public interface GroupService {

	public Response getGroup(int groupId);

	public Response addStudents(int groupId, Person person);
}