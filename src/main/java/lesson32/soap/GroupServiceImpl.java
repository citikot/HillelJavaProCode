package lesson32.soap;

import jakarta.jws.WebService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lesson07.xml.json.Group;
import lesson07.xml.json.Person;

/**
 * @author spasko
 */
// Service Implementation
@WebService(endpointInterface = "lesson32.soap.GroupService")
public class GroupServiceImpl implements GroupService {
	private static Map<Integer, Group> groups = Arrays.asList(Group.groupExampleCreator()).stream()
			.collect(Collectors.toMap(Group::getId, Function.identity()));

	@Override
	public Group getGroup(Integer groupId) {
		return groups.get(groupId);
	}

	@Override
	public Group addStudents(Integer groupId, List<Person> persons) {
		Group group = groups.get(groupId);
		if (group != null) {
			group.getStudents().addAll(persons);
			return group;
		} else
			return null;
	}

}