package lesson07.xml.json;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.IOException;

/**
 * @author spasko
 */
public class MainClazzToJson {
    public static void main(String[] args) {

        Group group = Group.groupExampleCreator();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {

            writer.writeValue(new File("src\\main\\resources\\lesson07\\group.json"), group);
            System.out.println(writer.writeValueAsString(group));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}