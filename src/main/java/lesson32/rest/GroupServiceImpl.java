package lesson32.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lesson07.xml.json.Group;
import lesson07.xml.json.Person;

/**
 * @author spasko
 */
@Path("/{groupId}")
public class GroupServiceImpl implements GroupService {
	private static Map<Integer, Group> groups = Arrays.asList(Group.groupExampleCreator()).stream()
			.collect(Collectors.toMap(Group::getId, Function.identity()));

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroup(@PathParam("groupId") int groupId) {
		Group group = groups.get(groupId);
		if (group != null) {
			return Response.status(Status.OK).entity(groups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/students")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudents(@PathParam("groupId") int groupId, Person person) {
		Group group = groups.get(groupId);
		if (group != null) {
			group.getStudents().addAll(Arrays.asList(person));
			return Response.status(Status.ACCEPTED).entity(group).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

}
