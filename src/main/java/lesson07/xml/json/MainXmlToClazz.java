package lesson07.xml.json;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author spasko
 */
public class MainXmlToClazz {
    public static void main(String[] args) {

        try {
            File file = new File("src\\main\\resources\\lesson07\\group.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Group group = (Group) jaxbUnmarshaller.unmarshal(file);
            System.out.println(group);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}