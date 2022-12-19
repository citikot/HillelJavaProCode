package lesson07.xml.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * @author spasko
 */
public class MainJsonToClazz {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Group group = mapper.readValue(new File("src\\main\\resources\\lesson07\\group.json"),
                    Group.class);
            System.out.println(group);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}