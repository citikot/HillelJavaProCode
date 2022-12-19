package lesson07.xml.json;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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